package pro.fessional.wings.faceless.util;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static javax.swing.JOptionPane.showConfirmDialog;

/**
 * @author trydofor
 * @since 2020-07-07
 */
public class FlywaveInteractiveGui {

    static {
        System.setProperty("java.awt.headless", "false");
        Font font = new Font(Font.MONOSPACED, Font.PLAIN, 12);
        UIManager.put("OptionPane.messageFont", font);
        UIManager.put("TextArea.font", font);
        UIManager.put("TextPane.font", font);
    }

    public static Function<String, Boolean> askGui() {
        return msg -> {
            while (true) {
                int res = showConfirmDialog(null, msg,
                        "😺😸😹😻😼😽🙀😿😾😺",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (res == 0) {
                    return true;
                }
                else if (res == 1) {
                    return false;
                }
            }
        };
    }

    private static final LinkedList<BiConsumer<String, String>> hooked = new LinkedList<>();

    public static BiConsumer<String, String> logGui() {
        final BiConsumer<String, String> fun = new BiConsumer<>() {
            private final AtomicInteger counter = new AtomicInteger(0);
            private final JTextPane textPane = new JTextPane();

            {
                //textPane.setBounds(0, 0, 1200, 800);
                JScrollPane scrollPang = new JScrollPane(textPane);
                JFrame frame = new JFrame("😺😸😹😻😼😽🙀😿😾😺");
                frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                frame.add(scrollPang);
                frame.setSize(1200, 800);

                // 居中
                frame.setLocationRelativeTo(null);
                // 焦点
                frame.setState(Frame.NORMAL);
                frame.toFront();
                frame.requestFocus();
                frame.setVisible(true);
            }

            @Override
            public void accept(String s1, String s2) {
                String[] pt = s1.split("\\|", 2);
                String lvl = "INFO";
                String slf = s1;
                if (pt.length == 2) {
                    lvl = pt[0];
                    slf = pt[1];
                }
                String msg = s2.replace('\n', ' ').trim();
                String line = String.format("%03d %5s %-18s %s\n", counter.incrementAndGet(), lvl, slf, msg);
                if (SwingUtilities.isEventDispatchThread()) {
                    insertString(line);
                }
                else {
                    SwingUtilities.invokeLater(() -> insertString(line));
                }
            }

            private final Pattern colorPattern = Pattern.compile("(ERROR|WARN|\\d{10,})");

            private void insertString(String line) {
                Matcher matcher = colorPattern.matcher(line);
                int off = 0;
                LinkedHashMap<String, MutableAttributeSet> parts = new LinkedHashMap<>();
                while (matcher.find()) {

                    MutableAttributeSet at1 = new SimpleAttributeSet(textPane.getInputAttributes());
                    StyleConstants.setForeground(at1, Color.BLACK);
                    parts.put(line.substring(off, matcher.start()), at1);
                    Color color;
                    String key = matcher.group(1);
                    if (key.equalsIgnoreCase("ERROR")) {
                        color = Color.PINK;
                    }
                    else if (key.equalsIgnoreCase("WARN")) {
                        color = Color.ORANGE;
                    }
                    else {
                        color = Color.MAGENTA;
                        key = key.substring(0, 4) + "-" + key.substring(4, 8) + "-" + key.substring(8);
                    }

                    MutableAttributeSet at2 = new SimpleAttributeSet(textPane.getInputAttributes());
                    StyleConstants.setForeground(at2, color);
                    parts.put(key, at2);
                    off = matcher.end();
                }

                if (off < line.length()) {
                    MutableAttributeSet attributes = new SimpleAttributeSet(textPane.getInputAttributes());
                    StyleConstants.setForeground(attributes, Color.BLACK);
                    parts.put(line.substring(off), attributes);
                }

                try {
                    StyledDocument styled = textPane.getStyledDocument();
                    Document doc = textPane.getDocument();
                    for (Map.Entry<String, MutableAttributeSet> entry : parts.entrySet()) {
                        styled.insertString(doc.getLength(), entry.getKey(), entry.getValue());
                    }
                }
                catch (BadLocationException ignored) {
                    // ignore
                }
            }
        };
        if (hooked.isEmpty()) {
            hooked.add(fun);
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                int res = showConfirmDialog(null, """
                                程序退出了，要看的赶紧看!
                                重点关注ERROR内容，logger中更全

                                [yes] 直接退出
                                [no] 控制台<回车>退出""",
                        "😺😸😹😻😼😽🙀😿😾😺",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (res != 0) {
                    try {
                        for (BiConsumer<String, String> bc : hooked) {
                            bc.accept("WARN", "主程序已退出，在控制台(console)按<回车>退出");
                        }
                        System.out.println("主程序已退出，为保留日志窗口，卡 in.read() 呢！");
                        System.out.println("要在下面按<回车>才能退出，下面↓，下面↓");
                        //noinspection ResultOfMethodCallIgnored
                        System.in.read();
                    }
                    catch (IOException e) {
                        // ignore
                    }
                }
            }));
        }

        return fun;
    }

    public static void main(String[] args) {
        final BiConsumer<String, String> log = logGui();
        log.accept("INFO", "message 1");
        log.accept("WARN", "message 2");
        log.accept("ERROR", "message 3");
    }
}

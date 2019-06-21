package de.scyv.rollon;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.lang.System.exit;

public class Main {
    public static void main(final String[] args) throws AWTException {
        final Robot bot = new Robot();
        System.out.println("Keeping the screen on.");
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(() -> {
            System.out.println("Ping - " + Instant.now());
            bot.keyPress(KeyEvent.VK_SCROLL_LOCK);
            bot.keyRelease(KeyEvent.VK_SCROLL_LOCK);
            try {
                Thread.sleep(1000);
            } catch (final InterruptedException e) {
                e.printStackTrace();
                exit(1);
            }
            bot.keyPress(KeyEvent.VK_SCROLL_LOCK);
            bot.keyRelease(KeyEvent.VK_SCROLL_LOCK);
        }, 0, 3, TimeUnit.MINUTES);
    }
}

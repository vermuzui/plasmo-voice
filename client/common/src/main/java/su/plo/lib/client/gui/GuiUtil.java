package su.plo.lib.client.gui;

import com.google.common.collect.ImmutableList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import su.plo.lib.client.locale.MinecraftLanguage;
import su.plo.voice.api.client.audio.device.AudioDevice;
import su.plo.voice.api.client.audio.device.DeviceFactory;
import su.plo.voice.chat.TextComponent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class GuiUtil {

    private static final int MAX_TOOLTIP_LINES = 32;
    private static final int OPEN_AL_SOFT_PREFIX_LENGTH = "OpenAL Soft on ".length();

    public static List<TextComponent> multiLineTooltip(@NotNull MinecraftLanguage language,
                                                       @Nullable String translation) {
        if (translation == null) return Collections.emptyList();

        if (language.has(translation))
            return ImmutableList.of(TextComponent.translatable(translation));

        List<TextComponent> list = new ArrayList<>();
        for (int i = 1; i <= MAX_TOOLTIP_LINES; i++) {
            String line = translation + "_" + i;
            if (!language.has(line)) break;

            list.add(TextComponent.translatable(translation + "_" + i));
        }

        return list;
    }

    public static TextComponent formatDeviceName(@Nullable AudioDevice device, @NotNull DeviceFactory deviceFactory) {
        if (device == null)
            return TextComponent.translatable("gui.plasmovoice.devices.not_available");

        return formatDeviceName(device.getName(), deviceFactory);
    }

    public static TextComponent formatDeviceName(@Nullable String deviceName, @NotNull DeviceFactory deviceFactory) {
        if (deviceName == null)
            return formatDeviceName(deviceFactory.getDefaultDeviceName(), deviceFactory);

        return deviceName.startsWith("OpenAL Soft on ")
                ? TextComponent.literal(deviceName.substring("OpenAL Soft on ".length()))
                : TextComponent.literal(deviceName);
    }

    public static List<TextComponent> formatDeviceNames(Collection<String> deviceNames, @NotNull DeviceFactory deviceFactory) {
        List<TextComponent> list = new ArrayList<>();
        for (String deviceName : deviceNames) {
            list.add(formatDeviceName(deviceName, deviceFactory));
        }

        return list;
    }

    private GuiUtil() {
    }
}

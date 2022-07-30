package su.plo.voice.api;

import org.jetbrains.annotations.NotNull;
import su.plo.voice.api.addon.AddonManager;
import su.plo.voice.api.audio.codec.CodecManager;
import su.plo.voice.api.encryption.EncryptionManager;
import su.plo.voice.api.event.EventBus;

/**
 * The Plasmo Voice API
 */
public interface PlasmoVoice {

    /**
     * Gets the {@link AddonManager}
     *
     * This manager can be used to get addons
     *
     * @return the addon manager
     */
    @NotNull AddonManager getAddonManager();

    /**
     * Gets the {@link EventBus}, used for subscribing to
     * Plasmo Voice events
     *
     * @return the event bus
     */
    @NotNull EventBus getEventBus();

    /**
     * Gets the {@link EncryptionManager}
     *
     * This manager can be used to create an encryption or register a custom encryption
     *
     * @return the encryption manager
     */
    @NotNull EncryptionManager getEncryptionManager();

    /**
     * Gets the {@link CodecManager}
     *
     * This manager can be used to create a codec encoder/decoder or register a custom codec encoder/decoder
     *
     * @return the codec manager
     */
    @NotNull CodecManager getCodecManager();

    /**
     * Gets the Plasmo Voice version
     *
     * @return the Plasmo Voice version
     */
    @NotNull String getVersion();
}

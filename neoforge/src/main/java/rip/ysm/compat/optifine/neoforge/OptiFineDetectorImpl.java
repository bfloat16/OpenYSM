package rip.ysm.compat.optifine.neoforge;
import com.elfmcys.yesstevemodel.client.compat.optifine.OptiFineDetector;

public final class OptiFineDetectorImpl {

    private OptiFineDetectorImpl() {
    }

    public static boolean isOptifinePresent() {
        return OptiFineDetector.isOptifinePresent();
    }
}

package org.jason.everflame.anim;

import java.util.List;
import java.util.Map;

public class Animation {

    public final String id;
    public final float duration;
    public final Map<String, List<Keyframe>> keyframes;

    public Animation(String id, float duration, Map<String, List<Keyframe>> keyframes) {
        this.id = id;
        this.duration = duration;
        this.keyframes = keyframes;

    }

    public static class Keyframe {
        public final float time;
        public final float[] rotation;
        public Keyframe(float time, float[] rotation) {
            this.time = time;
            this.rotation = rotation;
        }
    }
}

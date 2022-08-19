package algorithms.binary_search;

public class FirstBadVersion {

    private final int badVersion;

    FirstBadVersion(int badVersion) {
        this.badVersion = badVersion;
    }

    public int firstBadVersion(int latest) {
        return validateMedian(1, latest);
    }

    private int validateMedian(int start, int end) {
        if (end - start == 0) return start;
        var medianVersion = start + (end - start) / 2;
        if (isBadVersion(medianVersion)) {
            return validateMedian(start, medianVersion);
        }
        return validateMedian(medianVersion + 1, end);
    }

    private boolean isBadVersion(int version) {
        return version >= badVersion;
    }
}

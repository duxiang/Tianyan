package com.example.artilleryandroid.osmmap;

import org.osmdroid.ResourceProxy.string;
import org.osmdroid.tileprovider.MapTile;
import org.osmdroid.tileprovider.tilesource.OnlineTileSourceBase;

public class GoogleChinaTileSource extends OnlineTileSourceBase {
    private static final String[] BASE_URL = {
            "http://mt0.google.cn/vt/lyrs=s,r@6250000&hl=zh-CN&gl=CN&src=app&expIds=201527&rlbl=1&s=Gali&x=%d&y=%d&z=%d",
            "http://mt1.google.cn/vt/lyrs=s,r@6250000&hl=zh-CN&gl=CN&src=app&expIds=201527&rlbl=1&s=Gali&x=%d&y=%d&z=%d",
            "http://mt2.google.cn/vt/lyrs=s,r@6250000&hl=zh-CN&gl=CN&src=app&expIds=201527&rlbl=1&s=Gali&x=%d&y=%d&z=%d",
            "http://mt3.google.cn/vt/lyrs=s,r@6250000&hl=zh-CN&gl=CN&src=app&expIds=201527&rlbl=1&s=Gali&x=%d&y=%d&z=%d" };
    private static final String NAME = "Google Map China(Ditu)";

    public GoogleChinaTileSource() {
        super(NAME, string.bing, 0, 21, 256, ".png", BASE_URL);
    }

    @Override
    public String getTileURLString(MapTile aTile) {
        return String.format(getBaseUrl(), aTile.getX(), aTile.getY(),
                aTile.getZoomLevel());
    }

}

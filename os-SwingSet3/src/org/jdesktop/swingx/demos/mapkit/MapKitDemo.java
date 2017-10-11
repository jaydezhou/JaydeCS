/*
 * Created on 28.03.2013
 *
 */
package org.jdesktop.swingx.demos.mapkit;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import org.jdesktop.swingx.JXMapKit;
import org.jdesktop.swingx.JXMapKit.DefaultProviders;
import org.jdesktop.swingx.mapviewer.DefaultTileFactory;
import org.jdesktop.swingx.mapviewer.GeoPosition;
import org.jdesktop.swingx.mapviewer.TileFactory;
import org.jdesktop.swingx.mapviewer.TileFactoryInfo;
import org.jdesktop.swingx.mapviewer.util.GeoUtil;
import org.jdesktop.swingxset.util.DemoUtils;

import com.sun.swingset3.DemoProperties;

/**
 * @author Jeanette Winzenburg, Berlin
 */
@DemoProperties(
        value = "JXMapKit",
//        category = "Controls",
        category = "SwingXSet",
        description = "Demonstrates JXMapKit, a compound map control in swingx-ws.",
        sourceFiles = {
            "org/jdesktop/swingx/demos/mapkit/MapKitDemo.java",
            "org/jdesktop/swingx/demos/mapkit/resources/images/MapKitDemo.png"
        }
    )

/**
 * Basically working, but extremely sluggish as webstartable, so removed again.
 */
public class MapKitDemo extends JPanel {
    
    public MapKitDemo() {
        createMapKitDemo();
        DemoUtils.injectResources(this);
        bind();
    }

    /**
     * 
     */
    private void createMapKitDemo() {
        setLayout(new BorderLayout());
        final JXMapKit kit = new JXMapKit();
        kit.setDefaultProvider(DefaultProviders.OpenStreetMaps);
        
        
        final int max = 17;
        TileFactoryInfo info = new TileFactoryInfo(1,max-2,max,
                256, true, true, // tile size is 256 and x/y orientation is normal
                "http://tile.openstreetmap.org",//5/15/10.png",
                "x","y","z") {
            public String getTileUrl(int x, int y, int zoom) {
                zoom = max-zoom;
                String url = this.baseURL +"/"+zoom+"/"+x+"/"+y+".png";
                return url;
            }

        };
        TileFactory tf = new DefaultTileFactory(info);
        kit.setTileFactory(tf);
        kit.setZoom(14);
        kit.setAddressLocation(new GeoPosition(51.5,0));
        kit.getMainMap().setDrawTileBorders(true);
        kit.getMainMap().setRestrictOutsidePanning(true);
        kit.getMainMap().setHorizontalWrapped(false);
        final GeoUtil gu = new GeoUtil(); 
        
        ((DefaultTileFactory)kit.getMainMap().getTileFactory()).setThreadPoolSize(8);
        add(kit);
    }
    /**
     * 
     */
    private void bind() {
    }


}

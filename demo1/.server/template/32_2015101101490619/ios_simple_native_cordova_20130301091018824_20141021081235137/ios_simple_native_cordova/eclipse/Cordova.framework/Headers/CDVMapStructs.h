//
//  Header.h
//  CordovaLib
//
//  Created by ufida on 12-8-27.
//  Copyright (c) 2012年 __MyCompanyName__. All rights reserved.
//

#ifndef CordovaLib_Header_h
#define CordovaLib_Header_h

#import "UMPDefinition.h"

enum DVMapTypeIdEnum{
    //displays a transparent layer of major streets on satellite images
    MAPTYPEID_HYBRID = 0,
    //displays a normal street map
    MAPTYPEID_ROADMAP = 1,
    //displays satellite images
    MAPTYPEID_SATELLITE = 2,
    //displays maps with physical features such as terrain and vegetation
    MAPTYPEID_TERRAIN = 3
};

//+----------------+ 
//+ TL    TC    TR + 
//+ LT          RT + 
//+                + 
//+ LC          RC + 
//+                + 
//+ LB          RB + 
//+ BL    BC    BR + 
//+----------------+ 
enum DVMapControlPositionEnum{
    //Elements are positioned in the center of the bottom row.(frame.w/2,frame.h-20-ctl.h)
    MAPCONTROLPOSITION_BOTTOM_CENTER = 0,
    //Elements are positioned in the bottom left and flow towards the middle. Elements are positioned to the right of the Google logo.(30,frame.h-20-ctl.h)
    MAPCONTROLPOSITION_BOTTOM_LEFT = 1,
    //Elements are positioned in the bottom right and flow towards the middle. Elements are positioned to the left of the copyrights.(frame.w-30-ctl.w,frame.y-20-ctl.h)
    MAPCONTROLPOSITION_BOTTOM_RIGHT = 2,
    //Elements are positioned on the left, above bottom-left elements, and flow upwards.(30,frame.h-20-ctl.h-ctl.h)
    MAPCONTROLPOSITION_LEFT_BOTTOM = 3,
    //Elements are positioned in the center of the left side.(30,frame.h/2)
    MAPCONTROLPOSITION_LEFT_CENTER = 4,
    //Elements are positioned on the left, below top-left elements, and flow downwards.(30,20+ctl.h*2)
    MAPCONTROLPOSITION_LEFT_TOP = 5,
	//Elements are positioned on the right, above bottom-right elements, and flow upwards.(frame.w-30-ctl.w,frame.h-20-ctl.h*2)
    MAPCONTROLPOSITION_RIGHT_BOTTOM = 6,
    //Elements are positioned in the center of the right side.(frame.w-30-ctl.w,frame.h/2)
    MAPCONTROLPOSITION_RIGHT_CENTER = 7,
    //Elements are positioned on the right, below top-right elements, and flow downwards.(frame.w-30-ctl.w,20+ctl.h*2)
    MAPCONTROLPOSITION_RIGHT_TOP = 8,
    //Elements are positioned in the center of the top row.(frame.w/2,20+ctl.h)
    MAPCONTROLPOSITION_TOP_CENTER = 9,
    //Elements are positioned in the top left and flow towards the middle.(30,20+ctl.h)
    MAPCONTROLPOSITION_TOP_LEFT = 10,
    //Elements are positioned in the top right and flow towards the middle.(frame.w-30-ctl.w,20+ctl.h)
    MAPCONTROLPOSITION_TOP_RIGHT = 11
};

enum DVMapTypeControlStyleEnum {
    //Uses the default map type control. The control which DEFAULT maps to will vary according to window size and other factors.
    MAPTYPECONTROLSTYLE_DEFAULT = 0,
    //A dropdown menu for the screen realestate conscious.
    MAPTYPECONTROLSTYLE_DROPDOWN_MENU = 1,
    //The standard horizontal radio buttons bar.
    MAPTYPECONTROLSTYLE_HORIZONTAL_BAR = 2
};

enum ScaleControlStyleEnum {
    SCALECONTROLSTYLE_DEFAULT = 0,
};

enum ZoomControlStyleEnum {
    ZOOMCONTROLSTYLE_DEFAULT = 0,
    ZOOMCONTROLSTYLE_LARGE = 1,
    ZOOMCONTROLSTYLE_SMALL = 2
    };

enum OverlayType {
    OVERLAYTYPE_CIRCLE = 0,
    OVERLAYTYPE_LINE = 1,
    OVERLAYTYPE_POLYGON = 2
    };

enum OptionEvents {
    OPTIONEVENTS_INVALID = 0,
    OPTIONEVENTS_CLICK = 1,
    OPTIONEVENTS_DBCLICK = 2,
    OPTIONEVENTS_DRAG = 3,
    OPTIONEVENTS_DRAGEND = 4
    };

#import <Foundation/Foundation.h>
@interface CircleOption : NSObject
{
        float flongtitude;
        float flatitude;        //LatLng	The center
        boolean_t clickable;	//boolean	Indicates whether this Circle handles mouse events. Defaults to true.
        boolean_t editable;     //boolean	If set to true, the user can edit this circle by dragging the control points shown at the center and around the circumference of the circle. Defaults to false.
        NSString* fillColor;	//string	The fill color. All CSS3 colors are supported except for extended named colors.
        float fillOpacity;      //number	The fill opacity between 0.0 and 1.0
        int mapid;              //Map	Map on which to display Circle.
        int radius;             //number	The radius in meters on the Earth's surface
        NSString*  strokeColor;	//string	The stroke color. All CSS3 colors are supported except for extended named colors.
        float    strokeOpacity;	//number	The stroke opacity between 0.0 and 1.0
        int       strokeWeight;	//number	The stroke width in pixels.
        boolean_t      visible;	//boolean	Whether this circle is visible on the map. Defaults to true.
        int        zIndex;      //number	The zIndex compared to other polys.
}
@property(nonatomic,assign) float flongtitude;
@property(nonatomic,assign) float flatitude; 
@property(nonatomic,assign) boolean_t clickable;	
@property(nonatomic,assign) boolean_t editable;     
@property(nonatomic,strong) NSString* fillColor;	
@property(nonatomic,assign) float fillOpacity;      
@property(nonatomic,assign) int mapid;              
@property(nonatomic,assign) int radius;             
@property(nonatomic,strong) NSString*  strokeColor;	
@property(nonatomic,assign) float    strokeOpacity;	
@property(nonatomic,assign) int       strokeWeight;	
@property(nonatomic,assign) boolean_t      visible;	
@property(nonatomic,assign) int        zIndex;      
@end


@interface LineOption : NSObject
{
    boolean_t clickable;	//boolean	Indicates whether this Polyline handles mouse events. Defaults to true.
    boolean_t editable;     //boolean	If set to true, the user can edit this shape by dragging the control points shown at the vertices and on each segment. Defaults to false.
    boolean_t geodesic;     //boolean	When true, render each edge as a geodesic (a segment of a "great circle"). A geodesic is the shortest path between two points along the surface of the Earth. When false, render each edge as a straight line on screen. Defaults to false.
    //icons	//Array.<IconSequence>	The icons to be rendered along the polyline.
    int mapid;              //Map	Map on which to display Polyline.
    NSMutableArray* pointsequence;	//e.g [[lat,lng],[lat,lng]] //MVCArray.<LatLng>|Array.<LatLng>	The ordered sequence of coordinates of the Polyline. This path may be specified using either a simple array of LatLngs, or an MVCArray of LatLngs. Note that if you pass a simple array, it will be converted to an MVCArray Inserting or removing LatLngs in the MVCArray will automatically update the polyline on the map.
    NSString* strokeColor;	//string	The stroke color. All CSS3 colors are supported except for extended named colors.
    float strokeOpacity;	//number	The stroke opacity between 0.0 and 1.0
    int strokeWeight;       //number	The stroke width in pixels.
    boolean_t   visible;	//boolean	Whether this polyline is visible on the map. Defaults to true.
    int     zIndex;         //number	The zIndex compared to other polys.
}

@property(nonatomic,assign) boolean_t clickable;
@property(nonatomic,assign) boolean_t editable; 
@property(nonatomic,assign) boolean_t geodesic;     
//icons	//Array.<IconSequence>	The icons to be rendered along the polyline.
@property(nonatomic,assign) int mapid;   
@property(nonatomic,strong) NSMutableArray* pointsequence;	
@property(nonatomic,strong) NSString* strokeColor;	
@property(nonatomic,assign) float strokeOpacity;	
@property(nonatomic,assign) int strokeWeight;  
@property(nonatomic,assign) boolean_t   visible;	
@property(nonatomic,assign) int     zIndex;         
@end

@interface PolygonOption : NSObject
{
    boolean_t clickable;            //boolean	Indicates whether this Polygon handles mouse events. Defaults to true.
    boolean_t editable;             //boolean	If set to true, the user can edit this shape by dragging the control points shown at the vertices and on each segment. Defaults to false.
    NSString* fillColor;            //string	The fill color. All CSS3 colors are supported except for extended named colors.
    float fillOpacity;              //number	The fill opacity between 0.0 and 1.0
    boolean_t geodesic;             //boolean	When true, render each edge as a geodesic (a segment of a "great circle"). A geodesic is the shortest path between two points along the surface of the Earth. When false, render each edge as a straight line on screen. Defaults to false.
    int mapid;                      //Map	Map on which to display Polygon.
    NSMutableArray* pointsequence;  //paths;	//MVCArray.<MVCArray.<LatLng>>|MVCArray.<LatLng>|Array.<Array.<LatLng>>|Array.<LatLng>	The ordered sequence of coordinates that designates a closed loop. Unlike polylines, a polygon may consist of one or more paths. As a result, the paths property may specify one or more arrays of LatLng coordinates. Simple polygons may be defined using a single array of LatLngs. More complex polygons may specify an array of arrays. Any simple arrays are convered into MVCArrays. Inserting or removing LatLngs from the MVCArray will automatically update the polygon on the map.
    NSString* strokeColor;          //string	The stroke color. All CSS3 colors are supported except for extended named colors.
    float strokeOpacity;            //number	The stroke opacity between 0.0 and 1.0
    int strokeWeight;               //number	The stroke width in pixels.
    boolean_t visible;              //boolean	Whether this polygon is visible on the map. Defaults to true.
    int zIndex;                     //number	The zIndex compared to other polys.
    
}
@property(nonatomic,assign) boolean_t clickable;
@property(nonatomic,assign) boolean_t editable;
@property(nonatomic,strong) NSString* fillColor;
@property(nonatomic,assign) float fillOpacity;
@property(nonatomic,assign) boolean_t geodesic;
@property(nonatomic,assign) int mapid;
@property(nonatomic,strong) NSMutableArray* pointsequence;
@property(nonatomic,strong) NSString* strokeColor;
@property(nonatomic,assign) float strokeOpacity;
@property(nonatomic,assign) int strokeWeight;
@property(nonatomic,assign) boolean_t visible;
@property(nonatomic,assign) int zIndex;
@end

enum AnnotationShowType {
    ANNOTATIONSHOW_BOUNCE = 0,
    ANNOTATIONSHOW_DROP = 1
    };

@interface UMPAnnotationOptions : NSObject
{
    NSString* titlename;
    NSString* subtitlename;
    
    NSString* imgpath;
    float latitude;
    float longitude;
    //boolean_t animateDrop;
    enum AnnotationShowType animateDrop;
    boolean_t showCallOut;
    boolean_t clickable;	//boolean	If true, the marker receives mouse and touch events. Default value is true.
    //cursor	//string	Mouse cursor to show on hover
    boolean_t draggable;	//boolean	If true, the marker can be dragged. Default value is false.
    //flat	//boolean	If true, the marker shadow will not be displayed.
    //icon	//string|MarkerImage|Symbol	Icon for the foreground,ios里面，目前由imgpath来确定更换图标。
    //int    mapid;	//Map|StreetViewPanorama	Map on which to display Marker.
    //    optimized	//boolean	Optimization renders many markers as a single static element. Optimized rendering is enabled by default. Disable optimized rendering for animated GIFs or PNGs, or when each marker must be rendered as a separate DOM element (advanced usage only).
    //        position	//LatLng	Marker position. Required.目前，由latitude和longitude完成
    //raiseOnDrag	boolean	If false, disables raising and lowering the marker on drag. This option is true by default.
    //shadow	string|MarkerImage|Symbol	Shadow image
    //shape	MarkerShape	Image map region definition used for drag/click.
    //title	//string	Rollover text
    boolean_t visible;	//boolean	If true, the marker is visible
    int       zIndex;	//number
}
@property(nonatomic,strong) NSString* titlename;
@property(nonatomic,strong) NSString* subtitlename;
@property(nonatomic,strong) NSString* imgpath;
@property(nonatomic,assign) float latitude;
@property(nonatomic,assign) float longitude;
@property(nonatomic,assign) enum AnnotationShowType animateDrop;
@property(nonatomic,assign) boolean_t showCallOut;
@property(nonatomic,assign) boolean_t clickable;
@property(nonatomic,assign) boolean_t draggable;
//@property(nonatomic,assign) int    mapid;
@property(nonatomic,assign) boolean_t visible;
@property(nonatomic,assign) int       zIndex;
@end

//belongs to forward-GeoCoding
@interface UMPReverseGeoCodeRequest : NSObject
//Address.
@property (nonatomic,strong) NSString* address;
@property (nonatomic,assign) double latitude;
@property (nonatomic,assign) double longitude;
@property (nonatomic,assign) int radius;
@end
#endif


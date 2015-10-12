//
//  CDVMapControllerViewController.h
//  CordovaLib
//
//  Created by ufida on 12-8-27.
//  Copyright (c) 2012年 __MyCompanyName__. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <MapKit/MapKit.h>
#import "CDVMapStructs.h"
#import "UMPDefinition.h"

#ifdef CORDOVALIBVERSION2_1_0
@interface DVMapTypeControlOptions:NSObject
{
    NSMutableDictionary*             mapTypeIds;
    enum DVMapControlPositionEnum    position;
    enum DVMapTypeControlStyleEnum   mapTypeControlStyle;
}
@property(nonatomic,strong) NSMutableDictionary*             mapTypeIds;
@property(nonatomic,assign) enum DVMapControlPositionEnum    position;
@property(nonatomic,assign) enum DVMapTypeControlStyleEnum   mapTypeControlStyle;
@end

#else
struct DVMapTypeControlOptions{
    //enum DVMapTypeIdEnum             mapTypeId;
    NSMutableDictionary*             mapTypeIds;
    enum DVMapControlPositionEnum    position;
    enum DVMapTypeControlStyleEnum   mapTypeControlStyle;
};
#endif

struct DVOverviewMapControlOptions {
    //Whether the control should display in opened mode or collapsed (minimized) mode. By default, the control is closed.
    boolean_t opened;
};

struct PanControlOptions {
    enum DVMapControlPositionEnum    position;
};

struct RotateControlOptions {
    enum DVMapControlPositionEnum    position;
};

struct ScaleControlOptions {
    enum DVMapControlPositionEnum    position;
    enum ScaleControlStyleEnum       style;
    
};

struct ZoomControlOptions {
    enum DVMapControlPositionEnum position;
    enum ZoomControlStyleEnum style;
};

#ifdef CORDOVALIBVERSION2_1_0
@interface CDVMapOptions:NSObject
{
    NSString*               backgroundColor;
    int                     centerX;
    int                     centerY;
    //    boolean_t               disableDefaultUI;		
    boolean_t               disableDoubleClickZoom;
    boolean_t               draggable;
    //    NSString*               draggableCursor;
    //    NSString*               draggingCursor;
    int                     heading;
    //    boolean_t               keyboardShortcuts;
    //    boolean_t               mapMaker;
    boolean_t               mapTypeControl;
    DVMapTypeControlOptions* mapTypeControlOptions;
    enum   DVMapTypeIdEnum  mapTypeId;
    int                     maxZoom;
    int                     minZoom;
    boolean_t               noClear;
    //    boolean_t               overviewMapControl;
    //    struct DVOverviewMapControlOptions overviewMapControlOptions;
    boolean_t               panControl;
    struct PanControlOptions    panControlOptions;
    boolean_t               rotateControl;
    struct RotateControlOptions rotateControlOptions;
    //    boolean_t               scaleControl;
    //    struct ScaleControlOptions     scaleControlOptions;
    //    boolean_t               scrollwheel;
    int                     tilt;
    int                     zoom;   //初始的zoomlevel
    //    boolean_t               zoomControl;
    //    struct ZoomControlOptions zoomControlOptions;
}
@property(nonatomic,strong) NSString*               backgroundColor;
@property(nonatomic,assign) int                     centerX;
@property(nonatomic,assign) int                     centerY;	
@property(nonatomic,assign) boolean_t               disableDoubleClickZoom;
@property(nonatomic,assign) boolean_t               draggable;
@property(nonatomic,assign) int                     heading;
@property(nonatomic,assign) boolean_t               mapTypeControl;
@property(nonatomic,strong) DVMapTypeControlOptions* mapTypeControlOptions;
@property(nonatomic,assign) enum   DVMapTypeIdEnum  mapTypeId;
@property(nonatomic,assign) int                     maxZoom;
@property(nonatomic,assign) int                     minZoom;
@property(nonatomic,assign) boolean_t               noClear;
@property(nonatomic,assign) boolean_t               panControl;
@property(nonatomic,assign) struct PanControlOptions    panControlOptions;
@property(nonatomic,assign) boolean_t               rotateControl;
@property(nonatomic,assign) struct RotateControlOptions rotateControlOptions;
@property(nonatomic,assign) int                     tilt;
@property(nonatomic,assign) int                     zoom;   //初始的zoomlevel
@end


#else
struct CDVMapOptions{
    NSString*               backgroundColor;
    int                     centerX;
    int                     centerY;
//    boolean_t               disableDefaultUI;		
    boolean_t               disableDoubleClickZoom;
    boolean_t               draggable;
//    NSString*               draggableCursor;
//    NSString*               draggingCursor;
    int                     heading;
//    boolean_t               keyboardShortcuts;
//    boolean_t               mapMaker;
    boolean_t               mapTypeControl;
    struct DVMapTypeControlOptions mapTypeControlOptions;
    enum   DVMapTypeIdEnum  mapTypeId;
    int                     maxZoom;
    int                     minZoom;
    boolean_t               noClear;
//    boolean_t               overviewMapControl;
//    struct DVOverviewMapControlOptions overviewMapControlOptions;
    boolean_t               panControl;
    struct PanControlOptions    panControlOptions;
    boolean_t               rotateControl;
    struct RotateControlOptions rotateControlOptions;
//    boolean_t               scaleControl;
//    struct ScaleControlOptions     scaleControlOptions;
//    boolean_t               scrollwheel;
    int                     tilt;
    int                     zoom;   //初始的zoomlevel
//    boolean_t               zoomControl;
//    struct ZoomControlOptions zoomControlOptions;
};
#endif

#if __IPHONE_OS_VERSION_MAX_ALLOWED < __IPHONE_5_0
// iPhone OS SDK 5.0 以前版本的处理
@interface CDVMapViewController : UIViewController <CLLocationManagerDelegate,MKMapViewDelegate,UIGestureRecognizerDelegate,MKReverseGeocoderDelegate>
#else
// iPhone OS SDK 5.0 以后版本的处理
@interface CDVMapViewController : UIViewController <CLLocationManagerDelegate,MKMapViewDelegate,UIGestureRecognizerDelegate>
#endif

{
    NSMutableDictionary* annotationdict;

}
@property (nonatomic,strong) MKMapView* mapView;
@property (nonatomic,strong) UISegmentedControl* mapTypeControl;
@property (nonatomic,strong) NSNumber* mapid;
@property (nonatomic,strong) NSString* callbackId_create;
@property (nonatomic,strong) NSMutableArray* overlayarray;
@property (nonatomic,strong) NSMutableDictionary* annotationdict;
@property (nonatomic,strong) UIWebView* parentwebview;
//保存当前各类手势事件的callback。
//参数第一项代表地图的回调事件,对应onsuccess的回调，第二个参数代表mark的回调事件，对应onfail的回调。
@property (nonatomic,strong) NSString* optionClickMapCallback;
@property (nonatomic,strong) NSString* optionDbClickMapCallback;
@property (nonatomic,strong) NSString* optionMoveMapCallback;
@property (nonatomic,strong) NSString* optionDragMapCallback;
@property (nonatomic,strong) NSString* optionDragendMapCallback;

//保存反响地理编码成功和失败的callback;
@property (nonatomic,strong) NSString* ReverseGeoCallback;

//持久化路径
@property (nonatomic,strong) NSString* annotationdictArchivePath;

//初始化地图引擎
-(void) InitMapEngine:(UIWebView*)parentewebview arguments:(NSMutableArray*)arguments withDict:(NSMutableDictionary*)options;
//关闭地图引擎
-(void) closeMapEngine:(NSMutableArray*)arguments withDict:(NSMutableDictionary*)options;

//添加，删除overlay等
-(void) addCircleOverlay:(NSString*)overlayStamp options:(CircleOption*)options;
-(void) addLineOverlay:(NSString*)overlayStamp options:(LineOption*)options;

-(void) addPolygonOverlay:(NSString*)overlayStamp options:(PolygonOption*)options;

-(NSNumber*) addAnnotation:(UMPAnnotationOptions*)options;
-(void) clearAnnotation:(NSNumber*)annotationid;
-(void) clear:(NSString*) overlayname;

//nsarry[0]：annotation的个数  ； nsarray[1..n]:annotationid
-(NSArray*) getAnnotationCountAndId;
//NSDictionary 的结构就是CDVUMPAnnotation的结构。
-(NSDictionary*) getAnnotationInfoById:(NSNumber*) annotationId;

#pragma mark -events
-(void) registListener:(NSMutableArray*)arguments withDict:(NSMutableDictionary*)options;


#pragma mark reversegeo
-(void) reverseGeocoder:(NSMutableArray*)arguments withDict:(NSMutableDictionary*)options;
-(boolean_t) IsPointInMapView:(double) latitude longitude:(double)longitude;
@end

@interface OverlayObj : NSObject
@property (nonatomic,assign) enum OverlayType overlaytype;
@property (nonatomic,strong) NSString* overlayStamp;
@property (nonatomic,strong) id<MKOverlay>  overlayobjpoint;
@property (nonatomic,strong) id<MKAnnotation> annotation;
@end

@interface CircleObj : OverlayObj
@property (nonatomic,strong) CircleOption*    options;

@end

@interface LineObj : OverlayObj
@property (nonatomic,strong) LineOption*    options;

@end

@interface PolygonObj : OverlayObj
@property (nonatomic,strong) PolygonOption* options;

@end

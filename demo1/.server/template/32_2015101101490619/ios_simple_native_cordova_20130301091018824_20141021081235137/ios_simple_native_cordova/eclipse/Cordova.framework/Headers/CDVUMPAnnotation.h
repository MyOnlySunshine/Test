//
//  CDVUMPAnnotation.h
//  CordovaLib
//
//  Created by ufida on 12-9-12.
//  Copyright (c) 2012年 __MyCompanyName__. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "MapKit/MapKit.h"
@interface CDVUMPAnnotation : NSObject <MKAnnotation,NSCoding>

@property(nonatomic,readonly) CLLocationCoordinate2D coordinate;
@property(nonatomic,copy) NSString* title;
@property(nonatomic,copy) NSString* subtitle;
@property(nonatomic,copy) NSString* imgPath; 
@property(nonatomic,assign) boolean_t animateDrop;
@property(nonatomic,assign) boolean_t showCallOut;
@property(nonatomic,assign) boolean_t clickable;
@property(nonatomic,assign) boolean_t draggable;
//@property(nonatomic,assign) int    mapid;
@property(nonatomic,assign) boolean_t visible;
@property(nonatomic,assign) int       zIndex;
@property(nonatomic,strong) NSString* clickMarkCallback;
@property(nonatomic,strong) NSString* dbclickMarkCallback;
@property(nonatomic,strong) NSString* dragMarkCallback;
@property(nonatomic,strong) NSString* dragendMarkCallback;

-(id)initUMPAnnotationWithCoordinate:(CLLocationCoordinate2D) coord;
-(void) setCoordinate:(CLLocationCoordinate2D)newCoordinate;

-(NSDictionary*) getAnnotationFormattDictionary;

-(boolean_t) dispatchCallback:(NSString*)callback EventType:(NSNumber*)eventType;
-(NSString*) getCallback:(int)eventType;
@end

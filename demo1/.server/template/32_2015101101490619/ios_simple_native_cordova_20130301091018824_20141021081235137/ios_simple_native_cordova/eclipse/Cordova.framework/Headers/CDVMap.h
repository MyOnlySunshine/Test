//
//  CDVMap.h
//  CordovaLib
//
//  Created by ufida on 12-8-27.
//  Copyright (c) 2012年 __MyCompanyName__. All rights reserved.
//

#import "CDVPlugin.h"
@class CDVMapViewController;


@interface CDVMap : CDVPlugin

@property (nonatomic,retain) NSMutableDictionary* mapControllerDict;

#pragma mark interface of CDVMap
//初始化地图引擎
-(void) InitMapEngine:(NSMutableArray*)arguments withDict:(NSMutableDictionary*)options;
//关闭地图引擎
-(void) closeMapEngine:(NSMutableArray*)arguments withDict:(NSMutableDictionary*)options;

#pragma mark method
-(void) addOverlay:(NSMutableArray*)arguments withDict:(NSMutableDictionary*)options;
-(void) addAnnotation:(NSMutableArray*)arguments withDict:(NSMutableDictionary*)options;
-(void) clearAnnotation:(NSMutableArray*)arguments withDict:(NSMutableDictionary*)options;
-(void) clear:(NSMutableArray*)arguments withDict:(NSMutableDictionary*)options;
//追加持久化mark的信息返回
-(void) getAnnotationCountAndId:(NSMutableArray*)arguments withDict:(NSMutableDictionary*)options;
//根据mapid和annotationid，获取annotation的信息
-(void) getAnnotationInfoById:(NSMutableArray*)arguments withDict:(NSMutableDictionary*)options;

#pragma mark events-regist
//参数第一项代表地图的回调事件，第二个参数代表mark的回调事件
-(void) registListener:(NSMutableArray*)arguments withDict:(NSMutableDictionary*)options;

#pragma mark mapsearch
-(void) IsPointInMapView:(NSMutableArray*)arguments withDict:(NSMutableDictionary*)options;
-(void) getGeoInfoByCoordinate:(NSMutableArray*)arguments withDict:(NSMutableDictionary*)options;
@end

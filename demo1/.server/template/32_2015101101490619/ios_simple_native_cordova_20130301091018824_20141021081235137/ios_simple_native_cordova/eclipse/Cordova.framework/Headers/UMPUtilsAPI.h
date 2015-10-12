//
//  UMPUtilsAPI.h
//  CordovaLib
//
//  Created by ufida on 12-9-13.
//  Copyright (c) 2012年 __MyCompanyName__. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface UMPUtilsAPI : NSObject
+(CGPoint) posEnum2Point:(int)posenum framesize:(CGSize)cgframesize ctlsize:(CGSize)cgctlsize;
+(NSNumber*) randomval:(NSMutableDictionary*)dict;
@end

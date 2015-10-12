//
//  UMPTapGestureRecognize.h
//  CordovaLib
//
//  Created by ufida on 12-9-17.
//  Copyright (c) 2012年 __MyCompanyName__. All rights reserved.
//
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "CDVMapStructs.h"

#define CURRENT_POINT   @"touchpoint"
#define PRE_POINT       @"pretouchpoint"

typedef void (^TouchesEventBlock)(NSSet * touches, UIEvent * event);
typedef void (^TouchesEventBlockPointDictionary)(NSMutableDictionary* touchData);
@interface UMPTapGestureRecognize : UIGestureRecognizer
@property(copy)TouchesEventBlockPointDictionary touchesSingleCallback;
@property(copy)TouchesEventBlockPointDictionary touchesDoubleCallback;
@property(copy)TouchesEventBlock touchesMoveCallback;
@property(copy)TouchesEventBlock touchesMoveEndCallback;
@property(nonatomic,assign)enum OptionEvents preState;
@property(nonatomic,unsafe_unretained)UIView* curview;
@end

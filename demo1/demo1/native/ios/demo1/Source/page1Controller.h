//
//  viewController.h
//
//
//  Created by zhangyuv.
//  Copyright (c) 2013年 yonyou. All rights reserved.
//
#include <UMIOSControls/RoyalBlue.h>
#import <UMIOSControls/UMIOSControls.h>
//#import "UMContainer.h"
#import "AppDelegate.h"





















@interface page1Controller:UMBaseViewController

@property (nonatomic,assign) BOOL navBarHidden;
@property (nonatomic,weak) UIViewController* parentController;
@property (nonatomic,strong) UMContainer* currentContainer;
@property (nonatomic,strong) NSMutableDictionary *contextDictionary;
@property (nonatomic,readonly,strong) UMLayoutView*  viewObject;
@property (nonatomic,strong) UMLayoutView*	Page1;
- (UMLayoutView*)Page1 BV_OBJC_METHOD_FAMILY_NONE;
@property (strong) UMLayoutView* viewPage0;
- (UMLayoutView*)viewPage0 BV_OBJC_METHOD_FAMILY_NONE;

@property (strong) UMLayoutView* wloginpanel;
- (UMLayoutView*)wloginpanel BV_OBJC_METHOD_FAMILY_NONE;

@property (strong) UMLayoutView* wuserpanel;
- (UMLayoutView*)wuserpanel BV_OBJC_METHOD_FAMILY_NONE;

@property (strong) UMLayoutView* wpasspanel;
- (UMLayoutView*)wpasspanel BV_OBJC_METHOD_FAMILY_NONE;


@property (strong) UMLayoutView* wotherpanel;
- (UMLayoutView*)wotherpanel BV_OBJC_METHOD_FAMILY_NONE;

@property (strong) UMLayoutView* wotheruserpanel;
- (UMLayoutView*)wotheruserpanel BV_OBJC_METHOD_FAMILY_NONE;
















@property (nonatomic,strong)UMEntityContext* context;
@property (nonatomic,strong)UMEntityContext* ctx;




@property (nonatomic,strong) UMView* wloginbutton;



@property (nonatomic,strong) UMView* wuserimg;

@property (nonatomic,strong) UMView* wusertext;

@property (nonatomic,strong) UMView* wpassimg;

@property (nonatomic,strong) UMView* wpasstext;

@property (nonatomic,strong) UMView* wregisterlabel;

@property (nonatomic,strong) UMView* wforgetpasslabel;

@property (nonatomic,strong) UMView* wfilllabel1;

@property (nonatomic,strong) UMView* wtencentimage;

@property (nonatomic,strong) UMView* wfilllabel2;

@property (nonatomic,strong) UMView* wsinaimage;

@property (nonatomic,strong) UMView* wfilllabel3;

@property (nonatomic,strong) UMView* wrenrenimage;

@property (nonatomic,strong) UMView* wfilllabel4;


- (void)dataBind:(NSString*)data;
- (id)initWithParentCtl:(UIViewController*)parentCtl;
//- (void)dispacherEventToWebview:(NSString*)params;
@end

//
//  CDVPicker.h
//  CordovaLib
//
//  Created by ufida on 12-7-27.
//  Copyright (c) 2012年 UMP. All rights reserved.
//

#import "CDVPlugin.h"

//
enum CDVPickerType {
    PickerTimeType = 0,   //e.g. hour|minutes|AM -> 6|53|AM
    PickerDateType = 1,   //e.g. months|day|year ->  Nov|7|2012
    PickerWholeType = 2,  //e.g. date ,hour,minutes,AM/PM -> Web Nov|7|2012
    PickerCountTimerType = 3, //e.g. hour,minute -> 1|53
    PickerTypeCustomType = 4  //e.g. custom define Type
};
typedef NSUInteger CDVPickerType;

//picker滚轮详细数据
@interface ColumnWheel : NSObject
{
    
    int wheelHeight;    //高
    int wheelWidth;     //宽
    int wheelIndex;     //索引
    int relevanceIdx;   //受第几项关联
    int relevanceToIdx; //影响第几项的滚轮
    NSString* datagroup;//数据分组
    NSString* wheelName;//滚轮名称
    NSMutableArray* wheelData;//实体数据
    int selectedIndex;  //当前选中的索引
}

@property (nonatomic,assign) int wheelIndex;
@property (nonatomic,assign) int wheelHeight;
@property (nonatomic,assign) int wheelWidth;
@property (nonatomic,assign) int relevanceIdx;
@property (nonatomic,assign) int relevanceToIdx;
@property (nonatomic,strong) NSString* datagroup;
@property (nonatomic,strong) NSString* wheelName;
@property (nonatomic,strong) NSMutableArray* wheelData;
@property (nonatomic,assign) int selectedIndex;

//创建滚轮
-(ColumnWheel*) createWheel:(int)wheelIdx wheelHeight:(int)wheelH wheelWidth:(int)wheelW ;
//取得数据
-(NSString*) getrowdata:(int)rowIdx;
//保存轮子的数据
-(void) saveWheelData:(NSMutableArray*)wheeldata ;

@end
@class CDVPicker;
@interface CDVPickerController : UIViewController<UIPickerViewDelegate,UIPickerViewDataSource>
{
    //阴影遮蔽层
    UIView* pshadowview;
    UIView* pickerview;
    //picker类别
    CDVPickerType pickertype;
    //picker轮子数
    NSInteger pickercolumn;
    //picker属性
    float pickerposx;
    float pickerposy;
    NSInteger pickerW;
    //162-216 ,not recommend change
    NSInteger pickerH;
    //picker轮子数组
    NSMutableArray* pickerwheelArr;
    NSMutableDictionary* columnDataDict;
    NSString* pickerName;
    NSNumber* pickerid;
    boolean_t useshadow;
    NSString* dateformat;//日期类型picker的显示样式

    //当前的picker按钮
    UIButton* pickerbtn;
    UIButton* pickerCancelbtn;
    NSString* callbackId;
    
    NSString* callbackId_showpicker;
    NSString* callbackId_getwheelitems;
    
    UIWebView* parentwebview;
    //CDVPicker
    CDVPicker* cdvpicker;
}

@property (nonatomic,strong) UIView* pshadowview;
@property (strong) UIView* pickerview;
@property (nonatomic,assign) CDVPickerType pickertype;
@property (nonatomic,assign) NSInteger pickercolumn;
@property (nonatomic,assign) float pickerposx;
@property (nonatomic,assign) float pickerposy;
@property (nonatomic,assign) NSInteger pickerW;
@property (nonatomic,assign) NSInteger pickerH;
@property (nonatomic,strong) NSMutableArray* pickerwheelArr;
@property (nonatomic,strong)   NSMutableDictionary* columnDataDict;
@property (nonatomic,strong) NSString* pickerName;
@property (nonatomic,strong) NSNumber* pickerid;
@property (nonatomic,assign) boolean_t useshadow;
@property (nonatomic,strong) UIButton* pickerbtn;
@property (nonatomic,strong) UIButton* pickerCancelbtn;
@property (nonatomic,strong) NSString* callbackId;
@property (nonatomic,strong) UIWebView* parentwebview;
@property (nonatomic,strong) NSString* callbackId_showpicker;
@property (nonatomic,strong) NSString* callbackId_getwheelitems;
@property (nonatomic,strong) NSString* dateformat;
@property (nonatomic,strong) CDVPicker* cdvpicker;
//add by zhangnan
@property (nonatomic,strong) NSString* callbackIdForOkBtn;
@property (nonatomic,strong) NSString* callbackIdForCancelBtn;

- (void) initialize:(UIView*) parentsview arguments:(NSMutableArray*)arguments 
                                            withDict:(NSMutableDictionary*)options ;
-(void) getScrollWheelItems:(NSMutableArray*)arguments withDict:(NSMutableDictionary*)options;
-(int) getScrollWheelSize;
-(NSString*) getScrollName:(int)index;
-(void) InitPickerOKButton:(NSMutableArray*)arguments withDict:(NSMutableDictionary*)options;
-(void) InitPickerCancelButton:(NSMutableArray*)arguments withDict:(NSMutableDictionary*)options;

@end


@interface CDVPicker : CDVPlugin
{
    //picker-Dictionary
    NSMutableDictionary* pickerDict;
}

@property (nonatomic,strong)  NSMutableDictionary* pickerDict;

-(void) deletePicker:(NSNumber*)pickerid;

-(void) CreatePicker:(NSMutableArray*)arguments withDict:(NSMutableDictionary*)options;
-(void) ClosePicker:(NSMutableArray*)arguments withDict:(NSMutableDictionary*)options;
-(void) ShowPicker:(NSMutableArray*)arguments withDict:(NSMutableDictionary*)options;
#pragma mark custompicker_btn_api
-(void) InitPickerButton:(NSMutableArray*)arguments withDict:(NSMutableDictionary*)options;
#pragma mark custompicker_api
-(void) getScrollWheelItems:(NSMutableArray*)arguments withDict:(NSMutableDictionary*)options;
-(void) getScrollWheelSize:(NSMutableArray*)arguments withDict:(NSMutableDictionary*)options;
-(void) GetWheelName:(NSMutableArray*)arguments withDict:(NSMutableDictionary*)options;

@end

@interface NSObject(SelectorExtension)
#if 0
-(id) performSelector:(SEL)aSelector withObjects:(NSArray*)objects;
#endif
@end
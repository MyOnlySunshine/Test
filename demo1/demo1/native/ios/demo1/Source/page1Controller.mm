//
//  viewController.m
//
//
//  Created by zhangyuv.
//  Copyright (c) 2013年 yonyou. All rights reserved.
//

#import "page1Controller.h"






















@interface page1Controller ()
{
    BOOL isResum;//适配安卓resum事件
    BOOL isDialog;//dialog标记
}
@end

@implementation page1Controller
@synthesize navBarHidden = _navBarHidden;
@synthesize viewObject = _viewObject;
@synthesize Page1 = _Page1;
@synthesize parentController = _parentController;
@synthesize currentContainer=_currentContainer;
@synthesize contextDictionary = _contextDictionary;
@synthesize context=_context;
@synthesize ctx = _ctx;

@synthesize viewPage0 = _viewPage0;

@synthesize wloginpanel = _wloginpanel;

@synthesize wuserpanel = _wuserpanel;

@synthesize wpasspanel = _wpasspanel;


@synthesize wotherpanel = _wotherpanel;

@synthesize wotheruserpanel = _wotheruserpanel;















static NSString *controllerC = @"Page1Controller";

static NSString *namespaceC = @"com.sunshine.demo1";

static NSString *ModelName = @"";


- (id)initWithParentCtl:(UIViewController*)parentCtl
{
    self = [super initWithNibName:nil bundle:nil];
    if (self) {
        if(parentCtl){
            self.parentController = parentCtl;
        }else{
            self.parentController = self;
        }
        _navBarHidden = YES;
        self.navigationItem.hidesBackButton = YES;
        _viewObject = [[UMLayoutView alloc] init];
        _Page1 = _viewObject;

            _viewObject.layoutType = Layout_vbox;

    _viewObject.weightUMPView = 0;
    _viewObject.paddingLeft = 0;
    _viewObject.paddingTop = 0;
    _viewObject.paddingRight = 0;
    _viewObject.paddingBottom = 0;
    _viewObject.marginLeft = 0;
    _viewObject.marginTop = 0;
    _viewObject.marginRight = 0;
    _viewObject.marginBottom = 0;//0;
    _viewObject.vAlignUMP = ALIGN_LEFT;
    _viewObject.hAlignUMP = ALIGN_CENTER;
    _viewObject.frame = CGRectMake(0, 0, [[UIScreen mainScreen] applicationFrame].size.width, [[UIScreen mainScreen] applicationFrame].size.height);
    _viewObject.bVisible = YES;
    _viewObject.disabled = NO;
    _viewObject.readOnly = NO;
    //_viewObject.isHeightFill = YES;
    //_viewObject.isWidthFill = YES;
    _viewObject.isHeightWrap = NO;
    _viewObject.isWidthWrap = NO;
       _viewObject.backgroundColor = [UIColor clearColor];

	   _viewObject.layoutType = Layout_vbox;


        _context = [[UMEntityContext alloc]init];
        _ctx = _context;
  		self.xnamespace = namespaceC;
        self.controllerid = controllerC;

         
    }
	return self;
}

#pragma mark  initview

- (void)initChilds
{
    _viewPage0 = [[UMLayoutView alloc] init];
    _viewPage0.controlId = @"viewPage0";
    _viewPage0.layoutType = Layout_vbox;
    [(UMLayoutView*)_Page1 addSubUMView:_viewPage0];
     //设置控件基本属性
    [UMCompatible initCommonProperty:_viewPage0 info:[NSDictionary dictionaryWithObjectsAndKeys:
                          @"0",@"weightUMPView",
                          @"0",@"paddingLeftUMP",
                          @"0",@"paddingTopUMP",
                          @"0",@"paddingRightUMP",
                          @"0",@"paddingBottomUMP",
                          @"0",@"marginLeft",
                          @"0",@"marginTop",
                          @"0",@"marginRight",
                          @"0",@"marginBottom",
                          @"ALIGN_LEFT",@"valignUMP",
                          @"ALIGN_CENTER",@"halignUMP",
                          @"YES",@"visible",
                          @"NO",@"disabled",
                          @"NO",@"readOnly",
                          @"YES",@"isHeightFill",
                          @"YES",@"isWidthFill",
                          @"NO",@"isHeightWrap", 
                          @"NO",@"isWidthWrap",
                          @"0",@"left",
                          @"0",@"top",
                          @"0",@"width",
                          @"0",@"height",
                          @"",@"color",
                          [UIColor colorWithRed:0.9607843 green:0.9607843 blue:0.9607843 alpha:1],@"backgroundColor",
                          @"",@"backgroundImagePath",
                          [UIColor clearColor],@"background_color_dis",
                          @"",@"border-top-style",
                          @"",@"border-top-width",
                          @"",@"border-top-color",
                          @"",@"border-left-style",
                          @"",@"border-left-width",
                          @"",@"border-left-color",
                          @"",@"border-right-style",
                          @"",@"border-right-width",
                          @"",@"border-right-color",
                          @"",@"border-bottom-style",
                          @"",@"border-bottom-width",
                          @"",@"border-bottom-color",
                          @"",@"display",
                          @"",@"gradient",
                          @"0",@"border-radius",
                          nil] container:self];




    _wloginpanel = [[UMLayoutView alloc] init];
    _wloginpanel.controlId = @"wloginpanel";
    _wloginpanel.layoutType = Layout_vbox;
    [(UMLayoutView*)_viewPage0 addSubUMView:_wloginpanel];
     //设置控件基本属性
    [UMCompatible initCommonProperty:_wloginpanel info:[NSDictionary dictionaryWithObjectsAndKeys:
                          @"0",@"weightUMPView",
                          @"0",@"paddingLeftUMP",
                          @"0",@"paddingTopUMP",
                          @"0",@"paddingRightUMP",
                          @"0",@"paddingBottomUMP",
                          @"0",@"marginLeft",
                          @"0",@"marginTop",
                          @"0",@"marginRight",
                          @"0",@"marginBottom",
                          @"ALIGN_LEFT",@"valignUMP",
                          @"ALIGN_CENTER",@"halignUMP",
                          @"YES",@"visible",
                          @"NO",@"disabled",
                          @"NO",@"readOnly",
                          @"YES",@"isHeightFill",
                          @"YES",@"isWidthFill",
                          @"NO",@"isHeightWrap", 
                          @"NO",@"isWidthWrap",
                          @"0",@"left",
                          @"0",@"top",
                          @"0",@"width",
                          @"0",@"height",
                          @"",@"color",
                          [UIColor colorWithRed:0.9490196 green:0.9490196 blue:0.9490196 alpha:1],@"backgroundColor",
                          @"",@"backgroundImagePath",
                          [UIColor clearColor],@"background_color_dis",
                          @"",@"border-top-style",
                          @"",@"border-top-width",
                          @"",@"border-top-color",
                          @"",@"border-left-style",
                          @"",@"border-left-width",
                          @"",@"border-left-color",
                          @"",@"border-right-style",
                          @"",@"border-right-width",
                          @"",@"border-right-color",
                          @"",@"border-bottom-style",
                          @"",@"border-bottom-width",
                          @"",@"border-bottom-color",
                          @"",@"display",
                          @"",@"gradient",
                          @"0",@"border-radius",
                          nil] container:self];




    _wuserpanel = [[UMLayoutView alloc] init];
    _wuserpanel.controlId = @"wuserpanel";
    _wuserpanel.layoutType = Layout_hbox;
    [(UMLayoutView*)_wloginpanel addSubUMView:_wuserpanel];
     //设置控件基本属性
    [UMCompatible initCommonProperty:_wuserpanel info:[NSDictionary dictionaryWithObjectsAndKeys:
                          @"0",@"weightUMPView",
                          @"0",@"paddingLeftUMP",
                          @"0",@"paddingTopUMP",
                          @"0",@"paddingRightUMP",
                          @"0",@"paddingBottomUMP",
                          @"10",@"marginLeft",
                          @"10",@"marginTop",
                          @"10",@"marginRight",
                          @"0",@"marginBottom",
                          @"ALIGN_CENTER",@"valignUMP",
                          @"ALIGN_LEFT",@"halignUMP",
                          @"YES",@"visible",
                          @"NO",@"disabled",
                          @"NO",@"readOnly",
                          @"NO",@"isHeightFill",
                          @"YES",@"isWidthFill",
                          @"NO",@"isHeightWrap", 
                          @"NO",@"isWidthWrap",
                          @"0",@"left",
                          @"0",@"top",
                          @"0",@"width",
                          @"44",@"height",
                          @"",@"color",
                          [UIColor clearColor],@"backgroundColor",
                          @"textboxbg.png",@"backgroundImagePath",
                          [UIColor clearColor],@"background_color_dis",
                          @"",@"border-top-style",
                          @"",@"border-top-width",
                          @"",@"border-top-color",
                          @"",@"border-left-style",
                          @"",@"border-left-width",
                          @"",@"border-left-color",
                          @"",@"border-right-style",
                          @"",@"border-right-width",
                          @"",@"border-right-color",
                          @"",@"border-bottom-style",
                          @"",@"border-bottom-width",
                          @"",@"border-bottom-color",
                          @"",@"display",
                          @"",@"gradient",
                          @"0",@"border-radius",
                          nil] container:self];




    _wpasspanel = [[UMLayoutView alloc] init];
    _wpasspanel.controlId = @"wpasspanel";
    _wpasspanel.layoutType = Layout_hbox;
    [(UMLayoutView*)_wloginpanel addSubUMView:_wpasspanel];
     //设置控件基本属性
    [UMCompatible initCommonProperty:_wpasspanel info:[NSDictionary dictionaryWithObjectsAndKeys:
                          @"0",@"weightUMPView",
                          @"0",@"paddingLeftUMP",
                          @"0",@"paddingTopUMP",
                          @"0",@"paddingRightUMP",
                          @"0",@"paddingBottomUMP",
                          @"10",@"marginLeft",
                          @"0",@"marginTop",
                          @"10",@"marginRight",
                          @"0",@"marginBottom",
                          @"ALIGN_CENTER",@"valignUMP",
                          @"ALIGN_LEFT",@"halignUMP",
                          @"YES",@"visible",
                          @"NO",@"disabled",
                          @"NO",@"readOnly",
                          @"NO",@"isHeightFill",
                          @"YES",@"isWidthFill",
                          @"NO",@"isHeightWrap", 
                          @"NO",@"isWidthWrap",
                          @"0",@"left",
                          @"0",@"top",
                          @"0",@"width",
                          @"44",@"height",
                          @"",@"color",
                          [UIColor clearColor],@"backgroundColor",
                          @"textboxbg.png",@"backgroundImagePath",
                          [UIColor clearColor],@"background_color_dis",
                          @"",@"border-top-style",
                          @"",@"border-top-width",
                          @"",@"border-top-color",
                          @"",@"border-left-style",
                          @"",@"border-left-width",
                          @"",@"border-left-color",
                          @"",@"border-right-style",
                          @"",@"border-right-width",
                          @"",@"border-right-color",
                          @"",@"border-bottom-style",
                          @"",@"border-bottom-width",
                          @"",@"border-bottom-color",
                          @"",@"display",
                          @"",@"gradient",
                          @"0",@"border-radius",
                          nil] container:self];




// --wloginbutton
    _wloginbutton = [UMControl creatControl:@"UMXButton" container:self  params:@{
                          @"p_txt_r":@"0.8980392",
                          @"font_size":@"20",
                          @"font-pressed-color":@"#e50011",
                          @"txt_g":@"1.0",
                          @"id":@"wloginbutton",
                          @"margin-right":@"10",
                          @"p_txt_b":@"0.06666667",
                          @"height":@"44",
                          @"font_family":@"ArialMT",
                          @"font-size":@"20",
                          @"value":@"登录",
                          @"txt_b":@"1.0",
                          @"p_txt_g":@"0.0",
                          @"halign":@"center",
                          @"width":@"fill",
                          @"txt_r":@"1.0",
                          @"bg_r":@"0.96862745",
                          @"color":@"#ffffff",
                          @"background":@"#f7931e",
                          @"margin-left":@"10",
                          @"font-family":@"default",
                          @"margin-top":@"15",
                          @"bg_b":@"0.11764706",
                          @"valign":@"center",
                          @"bg_g":@"0.5764706"}];
    [(UMLayoutView*)_wloginpanel addSubUMXView:_wloginbutton];

    _wotherpanel = [[UMLayoutView alloc] init];
    _wotherpanel.controlId = @"wotherpanel";
    _wotherpanel.layoutType = Layout_hbox;
    [(UMLayoutView*)_wloginpanel addSubUMView:_wotherpanel];
     //设置控件基本属性
    [UMCompatible initCommonProperty:_wotherpanel info:[NSDictionary dictionaryWithObjectsAndKeys:
                          @"0",@"weightUMPView",
                          @"0",@"paddingLeftUMP",
                          @"0",@"paddingTopUMP",
                          @"0",@"paddingRightUMP",
                          @"0",@"paddingBottomUMP",
                          @"10",@"marginLeft",
                          @"0",@"marginTop",
                          @"10",@"marginRight",
                          @"0",@"marginBottom",
                          @"ALIGN_TOP",@"valignUMP",
                          @"ALIGN_LEFT",@"halignUMP",
                          @"YES",@"visible",
                          @"NO",@"disabled",
                          @"NO",@"readOnly",
                          @"NO",@"isHeightFill",
                          @"YES",@"isWidthFill",
                          @"NO",@"isHeightWrap", 
                          @"NO",@"isWidthWrap",
                          @"0",@"left",
                          @"0",@"top",
                          @"0",@"width",
                          @"57",@"height",
                          @"",@"color",
                          [UIColor clearColor],@"backgroundColor",
                          @"",@"backgroundImagePath",
                          [UIColor clearColor],@"background_color_dis",
                          @"",@"border-top-style",
                          @"",@"border-top-width",
                          @"",@"border-top-color",
                          @"",@"border-left-style",
                          @"",@"border-left-width",
                          @"",@"border-left-color",
                          @"",@"border-right-style",
                          @"",@"border-right-width",
                          @"",@"border-right-color",
                          @"",@"border-bottom-style",
                          @"",@"border-bottom-width",
                          @"",@"border-bottom-color",
                          @"",@"display",
                          @"",@"gradient",
                          @"0",@"border-radius",
                          nil] container:self];




    _wotheruserpanel = [[UMLayoutView alloc] init];
    _wotheruserpanel.controlId = @"wotheruserpanel";
    _wotheruserpanel.layoutType = Layout_hbox;
    [(UMLayoutView*)_wloginpanel addSubUMView:_wotheruserpanel];
     //设置控件基本属性
    [UMCompatible initCommonProperty:_wotheruserpanel info:[NSDictionary dictionaryWithObjectsAndKeys:
                          @"0",@"weightUMPView",
                          @"0",@"paddingLeftUMP",
                          @"0",@"paddingTopUMP",
                          @"0",@"paddingRightUMP",
                          @"0",@"paddingBottomUMP",
                          @"10",@"marginLeft",
                          @"0",@"marginTop",
                          @"10",@"marginRight",
                          @"0",@"marginBottom",
                          @"ALIGN_CENTER",@"valignUMP",
                          @"ALIGN_LEFT",@"halignUMP",
                          @"YES",@"visible",
                          @"NO",@"disabled",
                          @"NO",@"readOnly",
                          @"NO",@"isHeightFill",
                          @"YES",@"isWidthFill",
                          @"NO",@"isHeightWrap", 
                          @"NO",@"isWidthWrap",
                          @"0",@"left",
                          @"0",@"top",
                          @"0",@"width",
                          @"52",@"height",
                          @"",@"color",
                          [UIColor clearColor],@"backgroundColor",
                          @"",@"backgroundImagePath",
                          [UIColor clearColor],@"background_color_dis",
                          @"",@"border-top-style",
                          @"",@"border-top-width",
                          @"",@"border-top-color",
                          @"",@"border-left-style",
                          @"",@"border-left-width",
                          @"",@"border-left-color",
                          @"",@"border-right-style",
                          @"",@"border-right-width",
                          @"",@"border-right-color",
                          @"",@"border-bottom-style",
                          @"",@"border-bottom-width",
                          @"",@"border-bottom-color",
                          @"",@"display",
                          @"",@"gradient",
                          @"0",@"border-radius",
                          nil] container:self];




// --wuserimg
    _wuserimg = [UMControl creatControl:@"UMXXImageView" container:self  params:@{
                          @"id":@"wuserimg",
                          @"height":@"44",
                          @"width":@"48",
                          @"scaletype":@"fitcenter",
                          @"src":@"fa_user.png",@"value":@""}];
    [(UMLayoutView*)_wuserpanel addSubUMXView:_wuserimg];

// --wusertext
    _wusertext = [UMControl creatControl:@"UMXTextField" container:self  params:@{
                          @"halign":@"LEFT",
                          @"placeholder":@"手机\\用户名\\邮箱",
                          @"width":@"fill",
                          @"font_size":@"14",
                          @"txt_r":@"0.6509804",
                          @"id":@"wusertext",
                          @"txt_g":@"0.6509804",
                          @"maxlength":@"256",
                          @"height":@"44",
                          @"color":@"#a6a6a6",
                          @"font_family":@"ArialMT",
                          @"font-size":@"14",
                          @"font-family":@"default",
                          @"txt_b":@"0.6509804",@"value":@""}];
    [(UMLayoutView*)_wuserpanel addSubUMXView:_wusertext];

// --wpassimg
    _wpassimg = [UMControl creatControl:@"UMXXImageView" container:self  params:@{
                          @"id":@"wpassimg",
                          @"height":@"44",
                          @"width":@"48",
                          @"scaletype":@"fitcenter",
                          @"src":@"fa_password.png",@"value":@""}];
    [(UMLayoutView*)_wpasspanel addSubUMXView:_wpassimg];

// --wpasstext
    _wpasstext = [UMControl creatControl:@"UMXTextField" container:self  params:@{
                          @"halign":@"LEFT",
                          @"placeholder":@"密码",
                          @"width":@"fill",
                          @"font_size":@"14",
                          @"txt_r":@"0.6509804",
                          @"id":@"wpasstext",
                          @"txt_g":@"0.6509804",
                          @"maxlength":@"256",
                          @"height":@"44",
                          @"color":@"#a6a6a6",
                          @"font_family":@"ArialMT",
                          @"font-size":@"14",
                          @"font-family":@"default",
                          @"txt_b":@"0.6509804",@"secure":@"YES",@"value":@""}];
    [(UMLayoutView*)_wpasspanel addSubUMXView:_wpasstext];

// --wregisterlabel
    _wregisterlabel = [UMControl creatControl:@"UMXLabel" container:self  params:@{
                          @"halign":@"left",
                          @"weight":@"1",
                          @"width":@"0",
                          @"font_size":@"12",
                          @"txt_r":@"0.0",
                          @"id":@"wregisterlabel",
                          @"txt_g":@"0.6392157",
                          @"height":@"18",
                          @"font_family":@"ArialMT",
                          @"color":@"#00a3e7",
                          @"font-size":@"12",
                          @"margin-left":@"7",
                          @"font-family":@"default",
                          @"margin-top":@"10",
                          @"txt_b":@"0.90588236",
                          @"valign":@"center",@"value":@"立即注册"}];
    [(UMLayoutView*)_wotherpanel addSubUMXView:_wregisterlabel];

// --wforgetpasslabel
    _wforgetpasslabel = [UMControl creatControl:@"UMXLabel" container:self  params:@{
                          @"halign":@"right",
                          @"weight":@"1",
                          @"width":@"0",
                          @"font_size":@"12",
                          @"txt_r":@"0.0",
                          @"id":@"wforgetpasslabel",
                          @"txt_g":@"0.6392157",
                          @"margin-right":@"7",
                          @"height":@"18",
                          @"font_family":@"ArialMT",
                          @"color":@"#00a3e7",
                          @"font-size":@"12",
                          @"font-family":@"default",
                          @"margin-top":@"10",
                          @"txt_b":@"0.90588236",
                          @"valign":@"center",@"value":@"忘记密码"}];
    [(UMLayoutView*)_wotherpanel addSubUMXView:_wforgetpasslabel];

// --wfilllabel1
    _wfilllabel1 = [UMControl creatControl:@"UMXLabel" container:self  params:@{
                          @"id":@"wfilllabel1",
                          @"halign":@"center",
                          @"height":@"20",
                          @"weight":@"1",
                          @"font_family":@"ArialMT",
                          @"width":@"0",
                          @"font-family":@"default",@"value":@""}];
    [(UMLayoutView*)_wotheruserpanel addSubUMXView:_wfilllabel1];

// --wtencentimage
    _wtencentimage = [UMControl creatControl:@"UMXXImageView" container:self  params:@{
                          @"id":@"wtencentimage",
                          @"height":@"50",
                          @"width":@"50",
                          @"scaletype":@"fitcenter",
                          @"src":@"icon_tencent.png",@"value":@""}];
    [(UMLayoutView*)_wotheruserpanel addSubUMXView:_wtencentimage];

// --wfilllabel2
    _wfilllabel2 = [UMControl creatControl:@"UMXLabel" container:self  params:@{
                          @"id":@"wfilllabel2",
                          @"halign":@"center",
                          @"height":@"20",
                          @"weight":@"1",
                          @"font_family":@"ArialMT",
                          @"width":@"0",
                          @"font-family":@"default",@"value":@""}];
    [(UMLayoutView*)_wotheruserpanel addSubUMXView:_wfilllabel2];

// --wsinaimage
    _wsinaimage = [UMControl creatControl:@"UMXXImageView" container:self  params:@{
                          @"id":@"wsinaimage",
                          @"height":@"50",
                          @"width":@"50",
                          @"scaletype":@"fitcenter",
                          @"src":@"icon_sina.png",@"value":@""}];
    [(UMLayoutView*)_wotheruserpanel addSubUMXView:_wsinaimage];

// --wfilllabel3
    _wfilllabel3 = [UMControl creatControl:@"UMXLabel" container:self  params:@{
                          @"id":@"wfilllabel3",
                          @"halign":@"center",
                          @"height":@"20",
                          @"weight":@"1",
                          @"font_family":@"ArialMT",
                          @"width":@"0",
                          @"font-family":@"default",@"value":@""}];
    [(UMLayoutView*)_wotheruserpanel addSubUMXView:_wfilllabel3];

// --wrenrenimage
    _wrenrenimage = [UMControl creatControl:@"UMXXImageView" container:self  params:@{
                          @"id":@"wrenrenimage",
                          @"height":@"50",
                          @"width":@"50",
                          @"scaletype":@"fitcenter",
                          @"src":@"icon_renren.png",@"value":@""}];
    [(UMLayoutView*)_wotheruserpanel addSubUMXView:_wrenrenimage];

// --wfilllabel4
    _wfilllabel4 = [UMControl creatControl:@"UMXLabel" container:self  params:@{
                          @"id":@"wfilllabel4",
                          @"halign":@"center",
                          @"height":@"20",
                          @"weight":@"1",
                          @"font_family":@"ArialMT",
                          @"width":@"0",
                          @"font-family":@"default",@"value":@""}];
    [(UMLayoutView*)_wotheruserpanel addSubUMXView:_wfilllabel4];


    [_viewObject adjustSize];
}

#pragma mark view on load

- (void)viewDidLoad
{
	[super viewDidLoad];
    [SysContext getInstance].CurrentViewController = self;



    //dialog优化，设置半透明背景色
    if(!isDialog){

         if ([[[UIDevice currentDevice] systemVersion] floatValue] >= 7) {
            self.view.bounds = CGRectMake(0, -20, self.view.frame.size.width, self.view.frame.size.height );
         }
    }else{

        //半透明蒙板
        UIView * bgview = [[UIView alloc] initWithFrame:self.view.frame];
        [bgview setBackgroundColor:[UIColor grayColor]];
        [bgview setOpaque:YES];
        [bgview setAlpha:0.5];
        [self.view addSubview:bgview];

    }

	[self.view addSubview:_viewObject.view];
    [self initChilds];
    


  
    




















    //加载JS
    AppDelegate* appDelegate = (AppDelegate*)[[UIApplication sharedApplication] delegate];
    _currentContainer = [appDelegate currentContainer];
   //[self performSelectorInBackground:@selector(umOnload) withObject:nil];
}
-(void)umOnload{

    @autoreleasepool {
    
        AppDelegate* appDelegate = (AppDelegate*)[[UIApplication sharedApplication] delegate];
        _currentContainer = [appDelegate currentContainer];
        
        _currentContainer.controllerName = [[namespaceC stringByAppendingString:@"."]stringByAppendingString:controllerC];
        [_currentContainer initCurrentViewController:_currentContainer.controllerName];
        
        [_currentContainer initCurrentViewContext:[[namespaceC stringByAppendingString:@"."]stringByAppendingString:ModelName]];
        
        
        
        //JS同步加载完成 回到主线程 刷新UI
        [self performSelectorOnMainThread:@selector(umload) withObject:nil waitUntilDone:YES];
        
  
    }
}
-(void)umload{

     




















}
- (void)viewWillAppear:(BOOL)animated
{
    [self resignFirstResponder];
    [super viewWillAppear:animated];
    [SysContext getInstance].CurrentViewController = self;

    if (isResum) {//第二次进入调用
          
    }else {
        isResum = YES;
    }
    [_viewObject umviewAppear];
    [UIApplication sharedApplication].keyWindow.backgroundColor = [UIColor colorWithHexString:@"#ffffff"];
    
    if([[UIColor getWhiteBlackByHexString:@"#ffffff"] isEqual:[UIColor blackColor]])
    {
        [[UIApplication sharedApplication] setStatusBarStyle:UIStatusBarStyleDefault];
    }
    else
    {
        [[UIApplication sharedApplication] setStatusBarStyle:UIStatusBarStyleLightContent];
    }

}
- (void)viewDidAppear:(BOOL)animated
{
	[super viewDidAppear:animated];
}
-(void)viewWillDisappear:(BOOL)animated
{
    [super viewWillDisappear:animated];
    
    [_viewObject vmviewDisappear];
}
- (void)viewDidUnload
{
	[super viewDidUnload];
}

#pragma mark  databind

- (void)dataBind:(NSString*)data{
    if(data !=nil){
        [_context updateCtx:data];
 _ctx = _context;

    }
    
    




















    [self bindAll];
   [_viewObject clearFinishedAdjustSize];
   [_viewObject adjustSize];
}

#pragma mark  actions































#pragma mark  InterfaceOrientation

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)toInterfaceOrientation
{
    return YES;
}
- (BOOL)shouldAutorotate
{
    return YES;
}
- (NSUInteger)supportedInterfaceOrientations
{
    //旋转Bug  return UIInterfaceOrientationMaskPortrait;

    return UIInterfaceOrientationMaskPortrait;
}


-(void)willRotateToInterfaceOrientation:(UIInterfaceOrientation)toInterfaceOrientation duration:(NSTimeInterval)duration
{

   //dialog和viewcontroller共用一份模版，添加判断
   if(!isDialog){

    CGRect frame;
    self.willOrientation = toInterfaceOrientation;
    frame = [self frameForOrientation];
    self.viewObject.frame = frame;
    [self.viewObject clearFinishedAdjustSize];
    [self.viewObject adjustSize];

    [_viewObject umviewAppear];
    [self operateOrientationViewDidAppear];
  }
}

#pragma mark  摇一摇

-(BOOL)canBecomeFirstResponder
{
    return YES;
}
- (void) motionBegan:(UIEventSubtype)motion withEvent:(UIEvent *)event
{
    
    if (motion == UIEventSubtypeMotionShake) {
        //NSLog(@"摇一摇");
        
        
    }
}

#pragma mark container

-(void)onInit{
    [_currentContainer onInit:controllerC];
}
-(void)onLoad{
    [_currentContainer onLoad:controllerC];
}
-(void)onDataBinding{
    //here do databinding
    NSString *context = [_currentContainer getModel:ModelName];
    _contextDictionary = [context objectFromJSONString];
    if(_contextDictionary != nil)
        [self dataBind:[_contextDictionary JSONString]];
}
-(void)onComplete{
    [_currentContainer onComplete:controllerC];
}
-(id)valueByBindfield:(NSString*)bindingfield
{
    return [_contextDictionary objectForKey:bindingfield];
}

@end

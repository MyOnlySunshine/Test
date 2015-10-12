#import "tabcontrolController.h"
@implementation tabcontrolController
@synthesize tab1=_tab1;
@synthesize tab2=_tab2;
@synthesize tab3=_tab3;
- (void)loadView
{
[super loadView];
}
- (void)viewDidLoad
{
[super viewDidLoad];
NSMutableArray* tabPageControllers_array = [NSMutableArray arrayWithCapacity:1];
_tab1=[[CustomUI_tab1Controller alloc] initWithNibName:nil bundle:nil];
UMPTabBarItem*_tab1ItemBar = [[UMPTabBarItem alloc] initWithTitle:@"" image:nil tag:0];
_tab1ItemBar.customUnselectedImage = [UIImage imageNamed:@"tab1"];
_tab1ItemBar.customSelectedImage = [UIImage imageNamed:@"tab1_focus"];
_tab1.tabBarItem =_tab1ItemBar;
[tabPageControllers_array addObject:_tab1];
_tab2=[[CustomUI_tab2Controller alloc] initWithNibName:nil bundle:nil];
UMPTabBarItem*_tab2ItemBar = [[UMPTabBarItem alloc] initWithTitle:@"" image:nil tag:0];
_tab2ItemBar.customUnselectedImage = [UIImage imageNamed:@"tab2"];
_tab2ItemBar.customSelectedImage = [UIImage imageNamed:@"tab2_focus"];
_tab2.tabBarItem =_tab2ItemBar;
[tabPageControllers_array addObject:_tab2];
_tab3=[[CustomUI_tab3Controller alloc] initWithNibName:nil bundle:nil];
UMPTabBarItem*_tab3ItemBar = [[UMPTabBarItem alloc] initWithTitle:@"" image:nil tag:0];
_tab3ItemBar.customUnselectedImage = [UIImage imageNamed:@"tab3"];
_tab3ItemBar.customSelectedImage = [UIImage imageNamed:@"tab3_focus"];
_tab3.tabBarItem =_tab3ItemBar;
[tabPageControllers_array addObject:_tab3];
 [self setViewControllers:tabPageControllers_array];
}
- (void)viewDidUnload
{
[super viewDidUnload];
}
@end

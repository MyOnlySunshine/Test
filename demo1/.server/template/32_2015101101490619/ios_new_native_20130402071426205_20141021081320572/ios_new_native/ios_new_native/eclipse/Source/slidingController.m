#import "slidingController.h"
#import "CustomUI_leftController.h"
#import "CustomUI_rightController.h"
@implementation slidingController
- (void)loadView
{
[super loadView];
}
- (void)viewDidLoad
{
CustomUI_leftController*left=[[CustomUI_leftController alloc] initWithNibName:nil bundle:nil];
self.leftViewCtl = left;
CustomUI_rightController*right=[[CustomUI_rightController alloc] initWithNibName:nil bundle:nil];
self.topViewCtl = right;
[super viewDidLoad];
}
- (void)viewDidUnload
{
[super viewDidUnload];
}
@end

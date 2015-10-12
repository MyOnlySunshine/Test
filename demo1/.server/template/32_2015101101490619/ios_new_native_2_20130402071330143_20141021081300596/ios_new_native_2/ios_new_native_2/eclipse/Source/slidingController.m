#import "slidingController.h"
@implementation slidingController
@synthesize left=_left;
@synthesize right=_right;
- (void)loadView
{
[super loadView];
}
- (void)viewDidLoad
{
_left=[[CustomUI_leftController alloc] initWithNibName:nil bundle:nil];
self.leftViewCtl = _left;
_right=[[CustomUI_rightController alloc] initWithNibName:nil bundle:nil];
self.topViewCtl = _right;
[super viewDidLoad];
}
- (void)viewDidUnload
{
[super viewDidUnload];
}
@end

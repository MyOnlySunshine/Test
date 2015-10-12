#import "CustomUI_tab1Controller.h"
#import "CustomUI_acController.h"

#import <QuartzCore/QuartzCore.h>
@implementation CustomUI_tab1Controller
- (void)loadView
{
[super loadView];
}
- (void)viewDidLoad
{
[super viewDidLoad];
}
- (void)viewWillAppear:(BOOL)animated
{
[super viewWillAppear:animated];
}
- (void)viewDidUnload
{
[super viewDidUnload];
}
- (IBAction)nextPage{
[super nextPage];
    CATransition* animation = [CATransition animation];
    animation.delegate = self;
    animation.duration = 0.25f;
    animation.timingFunction = UIViewAnimationCurveEaseInOut;
    animation.fillMode = kCAFillModeForwards;
    animation.type = kCATransitionPush;
    animation.subtype = kCATransitionFromRight;
    [self.view.layer addAnimation:animation forKey:@"ani1"];
}
- (IBAction)Close{
[super Close];
}
- (IBAction)Ok{
[super Ok];
}
@end

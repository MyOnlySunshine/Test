#import "CustomUI_acController.h"
#import "CustomUI_acController.h"

#import <QuartzCore/QuartzCore.h>
@implementation CustomUI_acController
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
}
- (IBAction)Close{
    CATransition* animation = [CATransition animation];
    animation.delegate = self;
    animation.duration = 0.25f;
    animation.timingFunction = UIViewAnimationCurveEaseInOut;
    animation.fillMode = kCAFillModeForwards;
    animation.type = kCATransitionPush;
    animation.subtype = kCATransitionFromLeft;
    [self.view.superview.layer addAnimation:animation forKey:@"ani1"];
    [super Close];
}
- (IBAction)Ok{
[super Ok];
}
@end

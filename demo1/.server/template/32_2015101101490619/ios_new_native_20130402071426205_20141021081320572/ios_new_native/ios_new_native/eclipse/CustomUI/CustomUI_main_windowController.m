#import "CustomUI_main_windowController.h"
#import "CustomUI_acController.h"
@implementation CustomUI_main_windowController
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
CustomUI_acController* next = [[CustomUI_acController alloc] initWithNibName:nil bundle:nil];
[self.view addSubview:next.view];
}
- (IBAction)Close{
}
- (IBAction)Ok{
}
@end

#import "AppDelegate.h"
#import "CustomUI_main_windowController.h"
#import "UMContainer.h"
@implementation AppDelegate
@synthesize window = _window;
@synthesize currentContainer = _currentContainer;
- (void)dealloc
{
[_currentContainer release];
[_window release];
[super dealloc];
}
- (BOOL)application:(UIApplication*)application didFinishLaunchingWithOptions:(NSDictionary*)launchOptions
{
_currentContainer = [[UMContainer alloc] init];
self.window = [[[UIWindow alloc] initWithFrame:[[UIScreen mainScreen] bounds]] autorelease];
main_windowController*main_window=[[[main_windowController alloc] initWithNibName:nil bundle:nil] autorelease];
CGFloat main_windowwidth;
CGFloat main_windowheight;
main_windowwidth = [[UIScreen mainScreen] applicationFrame].size.width;
main_windowheight = [[UIScreen mainScreen] applicationFrame].size.height;
main_window.view.frame = CGRectMake(0,0,main_windowwidth,main_windowheight);
self.window.rootViewController =main_window;
[self.window makeKeyAndVisible];
return YES;
}
- (void)applicationWillResignActive:(UIApplication*)application
{
}
- (void)applicationDidEnterBackground:(UIApplication*)application
{
}
- (void)applicationWillEnterForeground:(UIApplication*)application
{
}
- (void)applicationDidBecomActive:(UIApplication*)application
{
}
- (void)applicationWillTerminate:(UIApplication*)application
{
}
@end

#import <UIKit/UIKit.h>
#import "UMBaseViewController.h"
#import "UMPControls.h"
@interface CustomerListController: UMBaseViewController <UITableViewDelegate,UITableViewDataSource>
{
NSMutableArray* m_cells_image;
NSMutableArray* m_cells_label;
}
@property(nonatomic, strong) NSMutableArray* m_cells_image;
@property(nonatomic, strong) NSMutableArray* m_cells_label;
@end

//
//  ViewController.m
//  webtest
//
//  Created by pujie on 8/21/12.
//  Copyright (c) 2012 __MyCompanyName__. All rights reserved.
//

#import "ViewController.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad
{
    
    UIWebView* webView  = [[[UIWebView alloc] initWithFrame:[[UIScreen mainScreen] bounds]] autorelease];	
    [webView setUserInteractionEnabled: YES ];	//是否支持交互
    [webView setDelegate: self];	//委托
     webView.scalesPageToFit = YES;
    [webView   setOpaque: YES ];	//透明
    webView.autoresizingMask = (UIViewAutoresizingFlexibleWidth | UIViewAutoresizingFlexibleHeight);// 自适应高度和宽度
    [self.view addSubview:webView];  
    
    
    NSString *path = [[NSBundle mainBundle] pathForResource:@"${init_page}" ofType:@"" inDirectory:@"" forLocalization:@"${base_url}"];
    NSURL *mainBundleURL = [NSURL fileURLWithPath:[[NSBundle mainBundle] resourcePath]];
    NSURL* url = [NSURL fileURLWithPath: path];//创建URL  
    NSURLRequest* request = [NSURLRequest requestWithURL:url];//创建NSURLRequest  
    [webView loadRequest:request];     
   }

- (void)viewDidUnload
{
    [super viewDidUnload];
    // Release any retained subviews of the main view.
}

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
    if ([[UIDevice currentDevice] userInterfaceIdiom] == UIUserInterfaceIdiomPhone) {
        return (interfaceOrientation != UIInterfaceOrientationPortraitUpsideDown);
    } else {
        return YES;
    }
}

@end

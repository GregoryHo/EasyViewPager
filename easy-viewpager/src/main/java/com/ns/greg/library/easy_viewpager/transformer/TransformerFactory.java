package com.ns.greg.library.easy_viewpager.transformer;

/**
 * @author Gregory
 * @since 2016/4/13
 */
public class TransformerFactory {

  private TransformerFactory() {
    throw new UnsupportedOperationException();
  }

  public static BaseTransformer orderAccordionTranformer() {
    return new AccordionTransformer();
  }

  public static BaseTransformer orderBackgroundToForegroundTransformer() {
    return new BackgroundToForegroundTransformer();
  }

  public static BaseTransformer orderCubeInTransformer() {
    return new CubeInTransformer();
  }

  public static BaseTransformer orderCubeOutTransformer() {
    return new CubeOutTransformer();
  }

  public static BaseTransformer orderDefaultTransformer() {
    return new DefaultTransformer();
  }

  public static BaseTransformer orderDepthTransformer() {
    return new DepthTransformer();
  }

  public static BaseTransformer orderFlipHorizontalTransformer() {
    return new FlipHorizontalTransformer();
  }

  public static BaseTransformer orderFlipVerticalTransformer() {
    return new FlipVerticalTransformer();
  }

  public static BaseTransformer orderForegroundToBackgroundTransformer() {
    return new ForegroundToBackgroundTransformer();
  }

  public static BaseTransformer orderRotateDownTransformer() {
    return new RotateDownTransformer();
  }

  public static BaseTransformer orderRotateUpTransformer() {
    return new RotateUpTransformer();
  }

  public static BaseTransformer orderScaleInOutTransformer() {
    return new ScaleInOutTransformer();
  }

  public static BaseTransformer orderScaleTransformer() {
    return new ScaleTransformer();
  }

  public static BaseTransformer orderStackTransformer() {
    return new StackTransformer();
  }

  public static BaseTransformer orderTabletTransformer() {
    return new TabletTransformer();
  }

  public static BaseTransformer orderZoomInTransformer() {
    return new ZoomInTransformer();
  }

  public static BaseTransformer orderZoomOutSlideTransformer() {
    return new ZoomOutSlideTransformer();
  }

  public static BaseTransformer orderZoomOutTransformer() {
    return new ZoomOutTransformer();
  }

  public static BaseTransformer orderFreezeTransformer() {
    return new FreezeTransformer();
  }
}

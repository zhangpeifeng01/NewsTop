/*
 * Copyright (C) 2008 ZXing authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.example.administrator.mytestrecyclerviewapplication.zxing.view;
import java.util.Collection;
import java.util.HashSet;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.example.administrator.mytestrecyclerviewapplication.R;
import com.example.administrator.mytestrecyclerviewapplication.zxing.camera.CameraManager;
import com.google.zxing.ResultPoint;

/**
 * This view is overlaid on top of the camera preview. It adds the viewfinder rectangle and partial
 * transparency outside it, as well as the laser scanner animation and result points.
 */
public final class ViewfinderView extends View {

  private static final long ANIMATION_DELAY = 100L;
  private static final int OPAQUE = 0xFF;
  private static final int CORNER_WIDTH = 10;
  private final Paint paint;
  private Bitmap resultBitmap;
  private final int maskColor;
  private final int resultColor;
  private final int frameColor;
  private final int laserColor;
  private final int resultPointColor;
  private int scannerAlpha;
  private Collection<ResultPoint> possibleResultPoints;
  private Collection<ResultPoint> lastPossibleResultPoints;
  private float density;
  private int ScreenRate;
 //扫描框四角的边框宽
	private static final int MIDDLE_LINE_WIDTH = 5;
	
  
	private int slideTop;
	
	
	private int slideBottom;
	boolean isFirst;
	
	
	//扫描框中横线距离左边距的距离
	private static final int MIDDLE_LINE_PADDING = 5;
	
	/**
	 * 扫描框中横线的移动速度
	 */
	private static final int SPEEN_DISTANCE = 15;
  // This constructor is used when the class is built from an XML resource.
  public ViewfinderView(Context context, AttributeSet attrs) {
    super(context, attrs);
    density = context.getResources().getDisplayMetrics().density;
    ScreenRate = (int)(20 * density);
    // Initialize these once for performance rather than calling them every time in onDraw().
    paint = new Paint();
    Resources resources = getResources();
    maskColor = resources.getColor(R.color.viewfinder_mask);
    resultColor = resources.getColor(R.color.result_view);
    frameColor = resources.getColor(R.color.viewfinder_frame);
    laserColor = resources.getColor(R.color.viewfinder_laser);
    resultPointColor = resources.getColor(R.color.possible_result_points);
    scannerAlpha = 0;
    possibleResultPoints = new HashSet<ResultPoint>(5);
  }

  @SuppressLint("DrawAllocation")
@Override
  public void onDraw(Canvas canvas) {
    Rect frame = CameraManager.get().getFramingRect();
    if (frame == null) {
      return;
    }

	//閸掓繂顫愰崠鏍﹁厬闂傚鍤庡鎴濆З閻ㄥ嫭娓舵稉濠呯珶閸滃本娓舵稉瀣珶
	if(!isFirst){
		isFirst = true;
		slideTop = frame.top;
		slideBottom = frame.bottom;
	}
    int width = canvas.getWidth();
    int height = canvas.getHeight();

    // Draw the exterior (i.e. outside the framing rect) darkened
    paint.setColor(resultBitmap != null ? resultColor : maskColor);
    //扫描框以上的阴影
    canvas.drawRect(0, 0, width, frame.top, paint);
    
    canvas.drawRect(0, frame.top, frame.left, frame.bottom +1, paint);
    canvas.drawRect(frame.right + 1, frame.top, width, frame.bottom + 1, paint);
    canvas.drawRect(0, frame.bottom + 1, width, height, paint);

    if (resultBitmap != null) {
      // Draw the opaque result bitmap over the scanning rectangle
      paint.setAlpha(OPAQUE);
      canvas.drawBitmap(resultBitmap, frame.left, frame.top, paint);
    } else {

      // Draw a two pixel solid black border inside the framing rect
      paint.setColor(frameColor);
      canvas.drawRect(frame.left, frame.top, frame.right + 1, frame.top + 2, paint);
      canvas.drawRect(frame.left, frame.top + 2, frame.left + 2, frame.bottom - 1, paint);
      canvas.drawRect(frame.right - 1, frame.top, frame.right + 1, frame.bottom - 1, paint);
      canvas.drawRect(frame.left, frame.bottom - 1, frame.right + 1, frame.bottom + 1, paint);

      paint.setColor(Color.BLUE);
		canvas.drawRect(frame.left, frame.top, frame.left + ScreenRate,
				frame.top + CORNER_WIDTH, paint);
		canvas.drawRect(frame.left, frame.top, frame.left + CORNER_WIDTH, frame.top
				+ ScreenRate, paint);
		canvas.drawRect(frame.right - ScreenRate, frame.top, frame.right,
				frame.top + CORNER_WIDTH, paint);
		canvas.drawRect(frame.right - CORNER_WIDTH, frame.top, frame.right, frame.top
				+ ScreenRate, paint);
		canvas.drawRect(frame.left, frame.bottom - CORNER_WIDTH, frame.left
				+ ScreenRate, frame.bottom, paint);
		canvas.drawRect(frame.left, frame.bottom - ScreenRate,
				frame.left + CORNER_WIDTH, frame.bottom, paint);
		canvas.drawRect(frame.right - ScreenRate, frame.bottom - CORNER_WIDTH,
				frame.right, frame.bottom, paint);
		canvas.drawRect(frame.right - CORNER_WIDTH, frame.bottom - ScreenRate,
				frame.right, frame.bottom, paint);
      
		
		slideTop += SPEEN_DISTANCE;
		if(slideTop >= frame.bottom-20){
			slideTop = frame.top;
		}
      
		 Resources res=getResources();
		 Bitmap bitmap=BitmapFactory.decodeResource(res, R.drawable.zx_code_line);
//		 Bitmap bitmap1=BitmapFactory.decodeResource(res, R.drawable.c_wg);
		 Matrix matrix = new Matrix();
		 float ratio=(float)(frame.right -frame.left)/bitmap.getWidth();
		 matrix.postScale(ratio,1.0f); //闂�灝鎷扮�鑺ユ杹婢堆呯級鐏忓繒娈戝В鏂剧伐
		 Matrix matrix1=new Matrix();
//		 float ratio1=(float)(frame.right -frame.left)/bitmap1.getWidth();
//		 matrix1.postScale(ratio1, 1f);
		 Bitmap resizeBmp = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(), bitmap.getHeight(),matrix,true);
 
//		 Bitmap resizeBmp1=  Bitmap.createBitmap(bitmap1,0,0, bitmap1.getWidth()-13,(slideTop-frame.top)+1,matrix1,true);
		 
//		 canvas.drawBitmap(resizeBmp1, frame.left+10, frame.top+7, paint);
		 canvas.drawBitmap(resizeBmp, frame.left + MIDDLE_LINE_PADDING, slideTop - MIDDLE_LINE_WIDTH/2, paint);
		if(bitmap!=null){
			bitmap.recycle();
//			bitmap1.recycle();
		}
		if(resizeBmp!=null){
			resizeBmp.recycle();
//			resizeBmp1.recycle();
		}
		 
		
   
      Collection<ResultPoint> currentPossible = possibleResultPoints;
      Collection<ResultPoint> currentLast = lastPossibleResultPoints;
      if (currentPossible.isEmpty()) {
        lastPossibleResultPoints = null;
      } else {
        possibleResultPoints = new HashSet<ResultPoint>(5);
        lastPossibleResultPoints = currentPossible;
        paint.setAlpha(OPAQUE);
        paint.setColor(resultPointColor);
        for (ResultPoint point : currentPossible) {
          canvas.drawCircle(frame.left + point.getX(), frame.top + point.getY(), 6.0f, paint);
        }
      }
      if (currentLast != null) {
        paint.setAlpha(OPAQUE / 2);
        paint.setColor(resultPointColor);
        for (ResultPoint point : currentLast) {
          canvas.drawCircle(frame.left + point.getX(), frame.top + point.getY(), 3.0f, paint);
        }
      }

      // Request another update at the animation interval, but only repaint the laser line,
      // not the entire viewfinder mask.
      postInvalidateDelayed(ANIMATION_DELAY, frame.left, frame.top-1, frame.right, frame.bottom);
    }
  }

  public void drawViewfinder() {
    resultBitmap = null;
    invalidate();
  }

  /**
   * Draw a bitmap with the result points highlighted instead of the live scanning display.
   *
   * @param barcode An image of the decoded barcode.
   */
  public void drawResultBitmap(Bitmap barcode) {
    resultBitmap = barcode;
    invalidate();
  }

  public void addPossibleResultPoint(ResultPoint point) {
    possibleResultPoints.add(point);
  }

}

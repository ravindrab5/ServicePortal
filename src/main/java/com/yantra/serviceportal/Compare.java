package com.yantra.serviceportal;

import com.yantra.serviceportal.util.ImageComparator;

public class Compare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImageComparator img=new ImageComparator("./Screenshots/uber-eats_base.jpg");
		try {
			img.compareImagesWithImageMagick("./Screenshots/uber-eats_base.png", "./Screenshots/uber-eats_act.jpg", "./Screenshots/uber-eats_diff.jpg");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

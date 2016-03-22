package materia;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Exercicios {
	public BufferedImage bright(BufferedImage img, float intensity) {
		BufferedImage out = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());

		for (int i = 0; i < img.getWidth(); i++) {
			for (int j = 0; j < img.getHeight(); j++) {
				// img.setRGB(i, j, (int) (img.getRGB(j, i) * intensity));

				Color pixel = new Color(img.getRGB(i, j));
				int r = (int) (pixel.getRed() * intensity);
				int g = (int) (pixel.getGreen() * intensity);
				int b = (int) (pixel.getBlue() * intensity);

				if (r > 255) {
					r = 255;
				}
				if (g > 255) {
					g = 255;
				}
				if (b > 255) {
					b = 255;
				}
				out.setRGB(i, j, new Color(r, g, b).getRGB());
			}
		}
		return out;
	}

	public BufferedImage grayscale(BufferedImage img) {
		BufferedImage out = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
		for (int i = 0; i < img.getWidth(); i++) {
			for (int j = 0; j < img.getHeight(); j++) {
				Color c = new Color(img.getRGB(i, j));
				double r = c.getRed() * 0.3 + c.getGreen() * 0.59 + c.getBlue() * 0.11;
				double g = c.getRed() * 0.3 + c.getGreen() * 0.59 + c.getBlue() * 0.11;
				double b = c.getRed() * 0.3 + c.getGreen() * 0.59 + c.getBlue() * 0.11;
				out.setRGB(i, j, new Color((int) r, (int) g, (int) b).getRGB());
			}
		}

		return out;
	}

	public BufferedImage threshold(BufferedImage img, int value) {
		BufferedImage out = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());

		for (int i = 0; i < img.getWidth(); i++) {
			for (int j = 0; j < img.getHeight(); j++) {
				Color c = new Color(img.getRGB(i, j));
				int r = c.getRed();
				int g = c.getGreen();
				int b = c.getBlue();

				if (c.getRed() >= value)
					r = 255;
				if (c.getGreen() >= value)
					g = 255;
				if (c.getBlue() >= value)
					b = 255;
				out.setRGB(i, j, new Color(r, g, b).getRGB());
			}
		}
		return out;
	}

	public BufferedImage subtract(BufferedImage img1, BufferedImage img2) {
		if (img1.getHeight() != img2.getHeight() && img1.getWidth() != img2.getWidth())
			return null;

		BufferedImage out = new BufferedImage(img1.getWidth(), img1.getHeight(), img1.getType());
		for (int i = 0; i < img1.getWidth(); i++) {
			for (int j = 0; j < img1.getHeight(); j++) {
				Color c = new Color(img1.getRGB(i, j));
				Color d = new Color(img2.getRGB(i, j));
				int r = c.getRed() - d.getRed();
				int g = c.getGreen() - d.getGreen();
				int b = c.getBlue() - d.getBlue();

				if (r < 0) {
					r = 0;
				}
				if (g < 0) {
					g = 0;
				}
				if (b < 0) {
					b = 0;
				}

				out.setRGB(i, j, new Color(r, g, b).getRGB());
			}
		}
		return out;
	}

	public BufferedImage add(BufferedImage img1, BufferedImage img2) {
		if (img1.getHeight() != img2.getHeight() && img1.getWidth() != img2.getWidth())
			return null;

		BufferedImage out = new BufferedImage(img1.getWidth(), img1.getHeight(), img1.getType());
		for (int i = 0; i < img1.getWidth(); i++) {
			for (int j = 0; j < img1.getHeight(); j++) {
				Color c = new Color(img1.getRGB(i, j));
				Color d = new Color(img2.getRGB(i, j));
				int r = c.getRed() + d.getRed();
				int g = c.getGreen() + d.getGreen();
				int b = c.getBlue() + d.getBlue();

				if (r > 255) {
					r = 255;
				}
				if (g > 255) {
					g = 255;
				}
				if (b > 255) {
					b = 255;
				}

				out.setRGB(i, j, new Color(r, g, b).getRGB());
			}
		}
		return out;
	}

	// percet betwen 0-1
	public BufferedImage lerp(BufferedImage img1, BufferedImage img2, float percent) {
		BufferedImage out = new BufferedImage(img1.getWidth(), img1.getHeight(), img1.getType());

		for (int i = 0; i < img1.getWidth(); i++) {
			for (int j = 0; j < img1.getHeight(); j++) {
				Color c = new Color(img1.getRGB(i, j));
				Color d = new Color(img2.getRGB(i, j));
				int r = (int) (c.getRed() * (1.0f - percent) + (d.getRed() * percent));
				int g = (int) (c.getGreen() * (1.0f - percent) + (d.getGreen() * percent));
				int b = (int) (c.getBlue() * (1.0f - percent) + (d.getBlue() * percent));

				if (r > 255) {
					r = 255;
				}
				if (g > 255) {
					g = 255;
				}
				if (b > 255) {
					b = 255;
				}
				if (r < 0) {
					r = 0;
				}
				if (g < 0) {
					g = 0;
				}
				if (b < 0) {
					b = 0;
				}

				out.setRGB(i, j, new Color(r, g, b).getRGB());
			}
		}

		return out;
	}

	public BufferedImage egaTable(BufferedImage img) {
		BufferedImage out = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
		for (int i = 0; i < img.getWidth(); i++) {
			for (int j = 0; j < img.getHeight(); j++) {
				Color c = new Color(img.getRGB(i, j));
				int r = (c.getRed() / 64) * 64;
				int g = (c.getGreen() / 64) * 64;
				int b = (c.getBlue() / 64) * 64;

				out.setRGB(i, j, new Color(r, g, b).getRGB());
			}

		}
		return out;
	}

	public BufferedImage linha(BufferedImage img, int x1, int y1, int x2, int y2, Color color) {
		BufferedImage out = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
		// equacao da reta
		double m;
		if ((x2 - x1) == 0) {
			m = 0;
		} else {
			m = (((double) y2 - y1) / (x2 - x1));
			System.out.println(m);
		}
		System.out.println("x2-x1 " + x2 + " " + x1);
		System.out.println("y2-y1 " + y2 + " " + y1);
		System.out.println("m = " + m);
		double m1 = 0;
		// TODO: if para m > abs(0) m < abs(0)
		// caso m > 0 desenhar por x else desenhar por y'
		if (x2 > x1) {
			for (int i = x2; i <= x1; i++) {
				m1 += m;
				out.setRGB(i, (int) (y1 + m1), color.getRGB());
			}
		} else {
			for (int i = x1; i <= x2; i++) {
				m1 += m;
				out.setRGB(i, (int) (y2 + m1), color.getRGB());
			}
		}
		return out;
	}

	
	//exemplo EGA com verigicacao
	public int getValueColorEGBA(int c){
		switch (c / 64) {
		case 0:
			if(c % 64 > 5){
				return 1*64;
			}
			return 0;
		case 1:
			if(c % 64 > 5){
				return 2*64;
			}
			return 1*64;
		case 2:
			if(c % 64 > 5){
				return 3*64;
			}
			return 2*64;
		case 3:
			if(c % 64 > 5){
				return 4*64;
			}
			return 3*64;
		default:
			break;
		}
		return 0;
	}
	
	public BufferedImage kernel(BufferedImage img, float[][] kernel){
		BufferedImage out = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
		for (int i = 0; i < img.getWidth(); i++) {
			for (int j = 0; j < img.getHeight(); j++) {
				
				
				for (int jx = 0; jx < 3; jx++) {
					for (int jy = 0; jy < 3; jy++) {
						int px = j + jx -1;
						int py = i + jy -1;
						if(px < 0 || px >= img.getWidth() || py < 0 || py>=img.getWidth())
							continue;
						
						Color c = new Color(img.getRGB(py, px));
						int r = (int) (c.getRed() * kernel[py][px]);
						int g = (int) (c.getGreen() * kernel[py][px]);
						int b = (int) (c.getBlue() * kernel[py][px]);
						out.setRGB(py, px, new Color(r,g,b).getRGB());
					}
				}
				
			}
			
		}
		return out;
	}
}
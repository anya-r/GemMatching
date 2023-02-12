
enum GemType 
{
    GREEN, BLUE, ORANGE; //define the different types of Gems, comma delimited
	//create a method that generates a random color and call this in contructor
	
}

public class Gem 
{	
	private GemType type;
	private int points;
	
	public Gem()
	{
		type = randColor();
		this.points = randPV();


	}
	public Gem(GemType type, int points)
	{
		this.type = type;
		this.points = points;

	}
	public GemType getType()
	{
		return this.type;

	}
	public int getPoints()
	{
		return this.points;
	}

	public String toString()
	{
		return type + " " + points;

	}
	public void draw(double x, double y)
	{
		StdDraw.setPenColor(StdDraw.WHITE);
		if (type == GemType.GREEN)
			StdDraw.picture(x, y, "gem_green.png");
		
		else if (type == GemType.BLUE)
			StdDraw.picture(x, y, "gem_blue.png");

		else 
			StdDraw.picture(x, y, "gem_orange.png");

		StdDraw.text(x, y, points + "");

		

	}
	private int randPV()
	{
		int[] set = {0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50};
		int random = (int)(Math.random() * 11);
		return set[random]; 
	}
	private GemType randColor()
	{
		int x = 0;
		x = (int)(Math.random() * 3) + 1;
		if (x == 1)
			return GemType.GREEN;
		if (x == 2)
			return GemType.BLUE;
		else
			return GemType.ORANGE;
	}
	
	
	
	
	
	/** Tester main method */
	public static void main(String [] args)
	{
		final int maxGems = 16;
		
		// Create a gem of each type
		Gem green  = new Gem(GemType.GREEN, 10);
		Gem blue   = new Gem(GemType.BLUE, 20);
		Gem orange = new Gem(GemType.ORANGE, 30);
		System.out.println(green  + ", " + green.getType()  + ", " + green.getPoints());		
		System.out.println(blue   + ", " + blue.getType()   + ", " + blue.getPoints());
		System.out.println(orange + ", " + orange.getType() + ", " + orange.getPoints());
		green.draw(0.3, 0.7);
		blue.draw(0.5, 0.7);
		orange.draw(0.7, 0.7);
		
		// A row of random gems
		for (int i = 0; i < maxGems; i++)
		{
			Gem g = new Gem();
			g.draw(1.0 / maxGems * (i + 0.5), 0.5);
		}
	}
}

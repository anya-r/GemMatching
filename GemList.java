
public class GemList 
{
    private Node head;
    private int size;
	
    private class Node
	{
		private Gem gem;
		private Node next;
	}

	public GemList()
	{
		head = null;
        size = 0;
	}
	
	public int size()
	{
        return size;
		
	}
	
	public void draw(double y)
	{
		
        if(head != null)
        {
            Node temp = head;
            int i = 0;
            while (temp != null)
            {
            
                temp.gem.draw(1.0 / 16 * (i + 0.5), y);
                temp = temp.next;
                i++;
            }
        } 
	}
	public String toString()
	{
		String x = "";
        if (head == null)
            return "<none>";
        Node temp = head;
        x += temp.gem.getType();
        while (temp.next != null)
        {
            temp = temp.next;
            x += " -> " + temp.gem.getType(); 
            
        }
        return x;
	}

	public void insertBefore(Gem gem, int index)
	{
        Node newGem = new Node();
        Node temp = head;
        newGem.gem = gem;
        if (size() == 0)
        {
            head = newGem;
            size++;
        }
        else if (index == 0)
        {
            newGem.next = head;

        }
        else if (index >= size())
        {
            temp = head;
            while (temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = newGem;
            size++;
        }
        else 
        {
            temp = head;
            index --;
            while (index > 0)
            {
                temp = temp.next;
                index--;
            }
            newGem.next = temp.next;
            temp.next = newGem;
            size++;
         
        }
	}
	public int score()
	{
        // int score = 0;
        // int group = 0;
        // int sameColor = 1;
        // if (size() == 0)
        //     return 0;
        // else if (size() == 1)
        // {
        //     return head.gem.getPoints();
        // }
        // else
        // {
        //     Node temp = head;
        //     for (int i = 0; i < (size()); i++)
        //     {
        //         group = temp.gem.getPoints();
        //         GemType colorOne = temp.gem.getType();
        //         GemType colorTwo = null;
        //         if (temp.next != null)
        //         {      
        //             colorTwo = temp.next.gem.getType();
        //             System.out.println(colorOne);
        //             System.out.println(colorTwo);
        //             if (colorOne == colorTwo)
        //             {
        //                 group += temp.next.gem.getPoints();
        //                 sameColor++;
        //                 System.out.println("group1");
        //                 System.out.println(group);
        //                 temp = temp.next;
        //                 i++;            
        //             }
        //             else
        //             {
        //                 sameColor = 1;
        //             }
        //             System.out.println("group2");
        //             System.out.println(group);
        //             score += group * sameColor;
        //             temp = temp.next;
        //             sameColor = 1;
        //         }
        //          else
        //         {
        //             System.out.println("samECOLOR");
        //             System.out.println(sameColor);
        //            if (sameColor == 1)
        //                 score += temp.gem.getPoints();
        //         }           
        //         System.out.println("score2");
        //         System.out.println(score);
        //     }
        //     return score;
        // }
        int score;
        if (head == null)
            return 0;
        else if (size() == 1)
            return head.gem.getPoints();
        else
        {
            Node temp = head;
            score = 0;
            int group = 0;
            int same = 0;
            GemType color = temp.gem.getType();

            for (int i = 0; i < size(); i++)
            {
                if (temp.gem.getType() == color)
                {
                    group += temp.gem.getPoints();
                    same++;
                }
                else
                {
                    score += group * same;
                    group = 0;
                    same = 1;
                    color = temp.gem.getType();
                    group = temp.gem.getPoints();
                }
                temp = temp.next;
            }
            score += group * same;
        }
        return score;
    }
            
     
        

	
	
	
	public static void main(String [] args)
	{
		GemList list = new GemList();
		System.out.println(list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.9);		
		
		list.insertBefore(new Gem(GemType.BLUE, 10), 0);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.8);
		
		list.insertBefore(new Gem(GemType.BLUE, 20), 99);  //not a mistake, should still work
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.7);
		
		list.insertBefore(new Gem(GemType.ORANGE, 30), 1);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.6);
		
		list.insertBefore(new Gem(GemType.ORANGE, 10), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.5);
		
		list.insertBefore(new Gem(GemType.ORANGE, 50), 3);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.4);
		
		list.insertBefore(new Gem(GemType.GREEN, 50), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.3);		
	}	
 }

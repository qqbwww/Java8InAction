package lambdasinaction.chap5;

/**
 * 一笔交易
 */
public class Transaction{

	//交易员
	private Trader trader;
	//交易年份
	private int year;
	//交易金额
	private int value;

	public Transaction(Trader trader, int year, int value)
	{
		this.trader = trader;
		this.year = year;
		this.value = value;
	}

	public Trader getTrader(){ 
		return this.trader;
	}

	public int getYear(){
		return this.year;
	}

	public int getValue(){
		return this.value;
	}
	
	public String toString(){
	    return "{" + this.trader + ", " +
	           "year: "+this.year+", " +
	           "value:" + this.value +"}";
	}
}
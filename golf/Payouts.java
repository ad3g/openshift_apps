package com.golf;

public class Payouts {

	private int pNumberPlayers = 0;
	private double pTotalPurse = 0;
	private double pFirstPlace = 0;
	private double pSecondPlace = 0;
//	private double pThirdPlace = 0;
	private double pCloseToPin = 0;
	private double pRemaining = 0;

	private void calculateRemaining(){
		pRemaining = pTotalPurse - pCloseToPin;
	}
	private void calculatePlaces(){
		
	}
	/*
		# players		16	15	14	13	12	11	10	9	8
		$ / player		$5	$5	$5	$5	$5	$5	$5	$5	$5
		Total Purse		$80	$75	$70	$65	$60	$55	$50	$45	$40
		Closest #1		$8	$8	$8	$8	$8	$8	$8	$8	$8
		Closest #2		$8	$8	$8	$8	$8	$8	$8	$8	$8
		$ Remaining		$64	$59	$54	$49	$44	$39	$34	$29	$24
											
		First Place		$42	$38	$35	$32	$29	$25	$22	$19	$16
		Second Place	$22	$21	$19	$17	$15	$14	$12	$10	$8
		Total Re-added	$80	$75	$70	$65	$60	$55	$50	$45	$40
	 */
	public void fill(){
		if (pNumberPlayers > 0 ){
			pTotalPurse = pNumberPlayers * 5;
			if (pNumberPlayers == 16)
			{
				pCloseToPin = 8;
				calculateRemaining();
			}
			if (pNumberPlayers == 15)
			{
				pCloseToPin = 8;
				calculateRemaining();
			}
			if (pNumberPlayers == 14)
			{
				pCloseToPin = 7;
				calculateRemaining();
			}
			if (pNumberPlayers == 13)
			{
				pCloseToPin = 7;
				calculateRemaining();
			}
			if (pNumberPlayers == 12)
			{
				pCloseToPin = 6;
				calculateRemaining();
			}
			if (pNumberPlayers == 11)
			{
				pCloseToPin = 6;
				calculateRemaining();
			}
			if (pNumberPlayers == 10)
			{
				pCloseToPin = 5;
				calculateRemaining();
			}
			if (pNumberPlayers == 9)
			{
				pCloseToPin = 5;
				calculateRemaining();
			}
			if (pNumberPlayers == 8)
			{
				pCloseToPin = 4;
				calculateRemaining();
			}
		}
	}
	/*
		# players	16	15	14	13	12	11	10	9	8
		$ / player	$5	$5	$5	$5	$5	$5	$5	$5	$5
		Total Purse	$80	$75	$70	$65	$60	$55	$50	$45	$40
		Closest #1	$8	$8	$8	$8	$8	$8	$8	$8	$8
		Closest #2	$8	$8	$8	$8	$8	$8	$8	$8	$8
		$ Remaining	$64	$59	$54	$49	$44	$39	$34	$29	$24
											
		First Place	$42	$38	$35	$32	$29	$25	$22	$19	$16
		Second Place	$22	$21	$19	$17	$15	$14	$12	$10	$8
		Total Re-added	$80	$75	$70	$65	$60	$55	$50	$45	$40
	 */

	public int getpNumberPlayers() {
		return pNumberPlayers;
	}
	public void setpNumberPlayers(int pNumberPlayers) {
		this.pNumberPlayers = pNumberPlayers;
	}
	public double getpTotalPurse() {
		return pTotalPurse;
	}
	public void setpTotalPurse(double pTotalPurse) {
		this.pTotalPurse = pTotalPurse;
	}
	public double getpFirstPlace() {
		return pFirstPlace;
	}
	public void setpFirstPlace(double pFirstPlace) {
		this.pFirstPlace = pFirstPlace;
	}
	public double getpSecondPlace() {
		return pSecondPlace;
	}
	public void setpSecondPlace(double pSecondPlace) {
		this.pSecondPlace = pSecondPlace;
	}
//	public double getpThirdPlace() {
//		return pThirdPlace;
//	}
//	public void setpThirdPlace(double pThirdPlace) {
//		this.pThirdPlace = pThirdPlace;
//	}
	public double getpCloseToPin() {
		return pCloseToPin;
	}
	public void setpCloseToPin(double pCloseToPin) {
		this.pCloseToPin = pCloseToPin;
	}
}

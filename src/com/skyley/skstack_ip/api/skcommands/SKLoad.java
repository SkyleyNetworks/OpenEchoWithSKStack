package com.skyley.skstack_ip.api.skcommands;


/**
* SKLOADコマンドに対応したクラス、SKCommandを継承
* @author Skyley Networks, Inc.
* @version 0.1
*/
public class SKLoad extends SKCommand {

	/**
	 * 引数チェック
	 */
	@Override
	public boolean checkArgs() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

	/**
	 * コマンド文字列組み立て
	 */
	@Override
	public void buildCommand() {
		// TODO 自動生成されたメソッド・スタブ
		commandString = "SKLOAD\r\n";
	}

}

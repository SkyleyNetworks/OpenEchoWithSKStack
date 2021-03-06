package com.skyley.skstack_ip.api.skcommands;

import java.io.OutputStream;

/**
 * SKSTACK-IP API<br>
 * SKCommandクラス<br>
 * SKコマンド送信を扱う抽象クラス
 * @author Skyley Networks, Inc.
 * @version 0.1
 *
*/
public abstract class SKCommand {
	/** コマンド文字列 */
	protected String commandString;

	/**
	 * コマンド文字列を取得
	 * @return コマンド文字列
	 */
	public String getCommandString() {
		return commandString;
	}

	/**
	 * 引数チェック<br>
	 * 具体的な処理は具象クラスが実装
	 * @return 引数が値域の範囲内:true, 範囲外:false
	 */
	public abstract boolean checkArgs();

	/**
	 * コマンド文字列を組立<br>
	 * 具体的な処理は具象クラスが実装
	 */
	public abstract void buildCommand();

	/**
	 * コマンドを送信
	 * @param out デバイス接続先を示す出力ポート
	 * @return 送信に成功:true, 失敗:false
	 */
	public boolean sendCommand(OutputStream out) {
		try {
			byte[] commandByte = commandString.getBytes("US-ASCII");
			out.write(commandByte);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * コマンド送信のテンプレートメソッド
	 * @param out デバイス接続先を示す出力ポート
	 * @return 送信に成功:true, 失敗:false
	 */
	public boolean issueCommand(OutputStream out) {
		if(!checkArgs())
		{
			return false;
		}

		buildCommand();

		if(!sendCommand(out)) {
			return false;
		}

		return true;
	}
}

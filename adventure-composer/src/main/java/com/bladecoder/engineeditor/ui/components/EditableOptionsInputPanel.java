/*******************************************************************************
 * Copyright 2014 Rafael Garcia Moreno.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.bladecoder.engineeditor.ui.components;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class EditableOptionsInputPanel extends InputPanel {
	EditableSelectBox input;
	
	EditableOptionsInputPanel(Skin skin, String title, String desc, boolean mandatory, String defaultValue, String[] options) {
		input = new EditableSelectBox(skin);
		init(skin, title, desc, input, mandatory, defaultValue);
		
		if(options != null)
    		input.setItems(options);
	}
	
	EditableOptionsInputPanel() {
	}

	public String getText() {
		return input.getSelected();
	}

	public void setText(String s) {
		if(s == null)
			return;
		
		input.setSelected(s);
	}

	public int getSelectedIndex() {
		return input.getSelectedIndex();
	}
}

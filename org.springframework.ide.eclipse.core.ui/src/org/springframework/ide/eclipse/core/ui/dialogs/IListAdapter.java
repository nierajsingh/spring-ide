/*
 * Copyright 2002-2004 the original author or authors.
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
package org.springframework.ide.eclipse.core.ui.dialogs;

import org.springframework.ide.eclipse.core.ui.dialogs.internal.IListDialogField;



/**
 * Change listener used by <code>ListDialogField</code> and <code>CheckedListDialogField</code>
 * @author Pierre-Antoine Grégoire
 */
public interface IListAdapter {

    /**
     * A button from the button bar has been pressed.
     */
    void customButtonPressed(IListDialogField field, int index);

    /**
     * The selection of the list has changed.
     */
    void selectionChanged(IListDialogField field);

    /**
     * En entry in the list has been double clicked
     */
    void doubleClicked(IListDialogField field);

}

/**
 */
package org.sheepy.vulkan.model.gui;

import org.eclipse.emf.common.util.EList;

import org.sheepy.vulkan.model.process.graphic.GraphicsPipeline;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>GUI Pipeline</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.gui.GUIPipeline#getWindows <em>Windows</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.gui.GuiPackage#getGUIPipeline()
 * @model
 * @generated
 */
public interface GUIPipeline extends GraphicsPipeline
{
	/**
	 * Returns the value of the '<em><b>Windows</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.gui.Window}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Windows</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Windows</em>' containment reference list.
	 * @see org.sheepy.vulkan.model.gui.GuiPackage#getGUIPipeline_Windows()
	 * @model containment="true"
	 * @generated
	 */
	EList<Window> getWindows();

} // GUIPipeline

/**
 */
package org.sheepy.lily.vulkan.model.process;

import org.sheepy.lily.core.model.types.LNamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IPipeline Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.IPipelineTask#isEnabled <em>Enabled</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getIPipelineTask()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IPipelineTask extends LNamedElement
{

	/**
	 * Returns the value of the '<em><b>Enabled</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled</em>' attribute.
	 * @see #setEnabled(boolean)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getIPipelineTask_Enabled()
	 * @model default="true" unique="false"
	 * @generated
	 */
	boolean isEnabled();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.IPipelineTask#isEnabled <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled</em>' attribute.
	 * @see #isEnabled()
	 * @generated
	 */
	void setEnabled(boolean value);
} // IPipelineTask

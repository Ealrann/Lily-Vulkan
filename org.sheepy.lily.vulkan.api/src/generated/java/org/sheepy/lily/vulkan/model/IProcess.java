/**
 */
package org.sheepy.lily.vulkan.model;

import org.sheepy.lily.core.model.types.LNamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IProcess</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.IProcess#isEnabled <em>Enabled</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.VulkanPackage#getIProcess()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IProcess extends IResourceContainer, LNamedElement, IExecutionManager
{
	/**
	 * Returns the value of the '<em><b>Enabled</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled</em>' attribute.
	 * @see #setEnabled(boolean)
	 * @see org.sheepy.lily.vulkan.model.VulkanPackage#getIProcess_Enabled()
	 * @model default="true" unique="false"
	 * @generated
	 */
	boolean isEnabled();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.IProcess#isEnabled <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled</em>' attribute.
	 * @see #isEnabled()
	 * @generated
	 */
	void setEnabled(boolean value);

} // IProcess

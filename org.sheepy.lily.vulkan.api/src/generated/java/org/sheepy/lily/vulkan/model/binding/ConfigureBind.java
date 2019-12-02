/**
 */
package org.sheepy.lily.vulkan.model.binding;

import org.sheepy.lily.vulkan.model.process.BindDescriptorSets;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configure Bind</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.ConfigureBind#getBindTask <em>Bind Task</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.binding.BindingPackage#getConfigureBind()
 * @model
 * @generated
 */
public interface ConfigureBind extends IConfigurationTask
{
	/**
	 * Returns the value of the '<em><b>Bind Task</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bind Task</em>' reference.
	 * @see #setBindTask(BindDescriptorSets)
	 * @see org.sheepy.lily.vulkan.model.binding.BindingPackage#getConfigureBind_BindTask()
	 * @model required="true"
	 * @generated
	 */
	BindDescriptorSets getBindTask();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.binding.ConfigureBind#getBindTask <em>Bind Task</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bind Task</em>' reference.
	 * @see #getBindTask()
	 * @generated
	 */
	void setBindTask(BindDescriptorSets value);

} // ConfigureBind

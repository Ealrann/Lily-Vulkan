/**
 */
package org.sheepy.lily.vulkan.model.binding;

import org.eclipse.emf.common.util.EList;
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
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.ConfigureBind#getBindTasks <em>Bind Tasks</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.binding.BindingPackage#getConfigureBind()
 * @model
 * @generated
 */
public interface ConfigureBind extends IConfigurationTask
{
	/**
	 * Returns the value of the '<em><b>Bind Tasks</b></em>' reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.process.BindDescriptorSets}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bind Tasks</em>' reference list.
	 * @see org.sheepy.lily.vulkan.model.binding.BindingPackage#getConfigureBind_BindTasks()
	 * @model required="true"
	 * @generated
	 */
	EList<BindDescriptorSets> getBindTasks();

} // ConfigureBind

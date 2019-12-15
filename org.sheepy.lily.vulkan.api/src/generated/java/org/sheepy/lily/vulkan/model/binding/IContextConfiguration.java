/**
 */
package org.sheepy.lily.vulkan.model.binding;

import org.eclipse.emf.common.util.EList;

import org.sheepy.lily.core.model.types.LNamedElement;

import org.sheepy.lily.vulkan.model.process.IProcessExtension;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IContext Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.IContextConfiguration#getTasks <em>Tasks</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.binding.BindingPackage#getIContextConfiguration()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IContextConfiguration extends LNamedElement, IProcessExtension
{
	/**
	 * Returns the value of the '<em><b>Tasks</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.binding.IConfigurationTask}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tasks</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.binding.BindingPackage#getIContextConfiguration_Tasks()
	 * @model containment="true"
	 * @generated
	 */
	EList<IConfigurationTask> getTasks();

} // IContextConfiguration

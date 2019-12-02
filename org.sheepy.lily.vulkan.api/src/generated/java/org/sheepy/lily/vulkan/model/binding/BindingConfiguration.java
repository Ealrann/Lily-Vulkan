/**
 */
package org.sheepy.lily.vulkan.model.binding;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.core.model.types.LNamedElement;

import org.sheepy.lily.vulkan.model.process.IProcessExtension;

import org.sheepy.lily.vulkan.model.resource.DescriptorSet;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.BindingConfiguration#getDescriptorsSets <em>Descriptors Sets</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.BindingConfiguration#getDescriptorSetStride <em>Descriptor Set Stride</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.BindingConfiguration#getTasks <em>Tasks</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.binding.BindingPackage#getBindingConfiguration()
 * @model
 * @generated
 */
public interface BindingConfiguration extends LNamedElement, IProcessExtension
{
	/**
	 * Returns the value of the '<em><b>Descriptors Sets</b></em>' reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.resource.DescriptorSet}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptors Sets</em>' reference list.
	 * @see org.sheepy.lily.vulkan.model.binding.BindingPackage#getBindingConfiguration_DescriptorsSets()
	 * @model required="true"
	 * @generated
	 */
	EList<DescriptorSet> getDescriptorsSets();

	/**
	 * Returns the value of the '<em><b>Descriptor Set Stride</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptor Set Stride</em>' attribute.
	 * @see #setDescriptorSetStride(int)
	 * @see org.sheepy.lily.vulkan.model.binding.BindingPackage#getBindingConfiguration_DescriptorSetStride()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getDescriptorSetStride();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.binding.BindingConfiguration#getDescriptorSetStride <em>Descriptor Set Stride</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Descriptor Set Stride</em>' attribute.
	 * @see #getDescriptorSetStride()
	 * @generated
	 */
	void setDescriptorSetStride(int value);

	/**
	 * Returns the value of the '<em><b>Tasks</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.binding.IConfigurationTask}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tasks</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.binding.BindingPackage#getBindingConfiguration_Tasks()
	 * @model containment="true"
	 * @generated
	 */
	EList<IConfigurationTask> getTasks();

} // BindingConfiguration

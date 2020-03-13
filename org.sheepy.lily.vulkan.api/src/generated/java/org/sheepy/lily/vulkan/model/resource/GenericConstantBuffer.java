/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.eclipse.emf.common.util.EList;

import org.sheepy.lily.core.model.variable.IModelVariable;
import org.sheepy.lily.core.model.variable.ModelVariablePkg;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generic Constant Buffer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.GenericConstantBuffer#getReferencedVariables <em>Referenced Variables</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.GenericConstantBuffer#getVariablePkg <em>Variable Pkg</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getGenericConstantBuffer()
 * @model
 * @generated
 */
public interface GenericConstantBuffer extends ConstantBuffer
{
	/**
	 * Returns the value of the '<em><b>Referenced Variables</b></em>' reference list.
	 * The list contents are of type {@link org.sheepy.lily.core.model.variable.IModelVariable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Variables</em>' reference list.
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getGenericConstantBuffer_ReferencedVariables()
	 * @model
	 * @generated
	 */
	EList<IModelVariable> getReferencedVariables();

	/**
	 * Returns the value of the '<em><b>Variable Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Pkg</em>' containment reference.
	 * @see #setVariablePkg(ModelVariablePkg)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getGenericConstantBuffer_VariablePkg()
	 * @model containment="true"
	 * @generated
	 */
	ModelVariablePkg getVariablePkg();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.GenericConstantBuffer#getVariablePkg <em>Variable Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Pkg</em>' containment reference.
	 * @see #getVariablePkg()
	 * @generated
	 */
	void setVariablePkg(ModelVariablePkg value);

} // GenericConstantBuffer

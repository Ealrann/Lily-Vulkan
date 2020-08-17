/**
 */
package org.sheepy.lily.vulkan.model.process;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorSet;
import org.sheepy.vulkan.model.enumeration.EBindPoint;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bind Descriptor Sets</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.BindDescriptorSets#getDescriptorSets <em>Descriptor Sets</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.BindDescriptorSets#getBindPoint <em>Bind Point</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.BindDescriptorSets#getStride <em>Stride</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getBindDescriptorSets()
 * @model
 * @generated
 */
public interface BindDescriptorSets extends IPipelineTask
{
	/**
	 * Returns the value of the '<em><b>Descriptor Sets</b></em>' reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.vulkanresource.DescriptorSet}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptor Sets</em>' reference list.
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getBindDescriptorSets_DescriptorSets()
	 * @model
	 * @generated
	 */
	EList<DescriptorSet> getDescriptorSets();

	/**
	 * Returns the value of the '<em><b>Bind Point</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EBindPoint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bind Point</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EBindPoint
	 * @see #setBindPoint(EBindPoint)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getBindDescriptorSets_BindPoint()
	 * @model required="true"
	 * @generated
	 */
	EBindPoint getBindPoint();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.BindDescriptorSets#getBindPoint <em>Bind Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bind Point</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EBindPoint
	 * @see #getBindPoint()
	 * @generated
	 */
	void setBindPoint(EBindPoint value);

	/**
	 * Returns the value of the '<em><b>Stride</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stride</em>' attribute.
	 * @see #setStride(int)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getBindDescriptorSets_Stride()
	 * @model default="0"
	 * @generated
	 */
	int getStride();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.BindDescriptorSets#getStride <em>Stride</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stride</em>' attribute.
	 * @see #getStride()
	 * @generated
	 */
	void setStride(int value);

} // BindDescriptorSets

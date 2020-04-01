/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering;

import org.sheepy.lily.core.model.variable.IModelVariable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Physical Entity Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntityVariable#getEntity <em>Entity</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntityVariable#getFeature <em>Feature</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getPhysicalEntityVariable()
 * @model
 * @generated
 */
public interface PhysicalEntityVariable extends IModelVariable
{
	/**
	 * Returns the value of the '<em><b>Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entity</em>' reference.
	 * @see #setEntity(PhysicalEntity)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getPhysicalEntityVariable_Entity()
	 * @model
	 * @generated
	 */
	PhysicalEntity getEntity();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntityVariable#getEntity <em>Entity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entity</em>' reference.
	 * @see #getEntity()
	 * @generated
	 */
	void setEntity(PhysicalEntity value);

	/**
	 * Returns the value of the '<em><b>Feature</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.lily.vulkan.extra.model.rendering.EPhysicalEntityFeature}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' attribute.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.EPhysicalEntityFeature
	 * @see #setFeature(EPhysicalEntityFeature)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getPhysicalEntityVariable_Feature()
	 * @model required="true"
	 * @generated
	 */
	EPhysicalEntityFeature getFeature();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntityVariable#getFeature <em>Feature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' attribute.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.EPhysicalEntityFeature
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(EPhysicalEntityFeature value);

} // PhysicalEntityVariable

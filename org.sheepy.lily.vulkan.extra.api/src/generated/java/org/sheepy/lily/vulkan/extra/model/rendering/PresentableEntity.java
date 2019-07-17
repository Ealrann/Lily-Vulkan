/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Presentable Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity#getPresentation <em>Presentation</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity#getScale <em>Scale</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getPresentableEntity()
 * @model
 * @generated
 */
public interface PresentableEntity extends PhysicalEntity
{
	/**
	 * Returns the value of the '<em><b>Presentation</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.sheepy.lily.vulkan.extra.model.rendering.Presentation#getPresentedEntities <em>Presented Entities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Presentation</em>' reference.
	 * @see #setPresentation(Presentation)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getPresentableEntity_Presentation()
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.Presentation#getPresentedEntities
	 * @model opposite="presentedEntities"
	 * @generated
	 */
	Presentation getPresentation();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity#getPresentation <em>Presentation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Presentation</em>' reference.
	 * @see #getPresentation()
	 * @generated
	 */
	void setPresentation(Presentation value);

	/**
	 * Returns the value of the '<em><b>Scale</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scale</em>' attribute.
	 * @see #setScale(double)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getPresentableEntity_Scale()
	 * @model default="1"
	 * @generated
	 */
	double getScale();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity#getScale <em>Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scale</em>' attribute.
	 * @see #getScale()
	 * @generated
	 */
	void setScale(double value);

} // PresentableEntity

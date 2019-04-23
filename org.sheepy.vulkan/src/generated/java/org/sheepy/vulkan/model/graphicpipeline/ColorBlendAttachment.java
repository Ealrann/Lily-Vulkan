/**
 */
package org.sheepy.vulkan.model.graphicpipeline;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.vulkan.model.enumeration.EBlendFactor;
import org.sheepy.vulkan.model.enumeration.EBlendOp;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Color Blend Attachment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#isBlendEnable <em>Blend Enable</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#getSrcColor <em>Src Color</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#getDstColor <em>Dst Color</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#getSrcAlpha <em>Src Alpha</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#getDstAlpha <em>Dst Alpha</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#getColorBlendOp <em>Color Blend Op</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#getAlphaBlendOp <em>Alpha Blend Op</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#isRedComponentEnable <em>Red Component Enable</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#isGreenComponentEnable <em>Green Component Enable</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#isBlueComponentEnable <em>Blue Component Enable</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#isAlphaComponentEnable <em>Alpha Component Enable</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getColorBlendAttachment()
 * @model
 * @generated
 */
public interface ColorBlendAttachment extends EObject
{
	/**
	 * Returns the value of the '<em><b>Blend Enable</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Blend Enable</em>' attribute.
	 * @see #setBlendEnable(boolean)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getColorBlendAttachment_BlendEnable()
	 * @model default="false" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='1 - Common'"
	 * @generated
	 */
	boolean isBlendEnable();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#isBlendEnable <em>Blend Enable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Blend Enable</em>' attribute.
	 * @see #isBlendEnable()
	 * @generated
	 */
	void setBlendEnable(boolean value);

	/**
	 * Returns the value of the '<em><b>Src Color</b></em>' attribute.
	 * The default value is <code>"ONE"</code>.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EBlendFactor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src Color</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EBlendFactor
	 * @see #setSrcColor(EBlendFactor)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getColorBlendAttachment_SrcColor()
	 * @model default="ONE" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='2 - Operation'"
	 * @generated
	 */
	EBlendFactor getSrcColor();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#getSrcColor <em>Src Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Src Color</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EBlendFactor
	 * @see #getSrcColor()
	 * @generated
	 */
	void setSrcColor(EBlendFactor value);

	/**
	 * Returns the value of the '<em><b>Dst Color</b></em>' attribute.
	 * The default value is <code>"ZERO"</code>.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EBlendFactor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dst Color</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EBlendFactor
	 * @see #setDstColor(EBlendFactor)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getColorBlendAttachment_DstColor()
	 * @model default="ZERO" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='2 - Operation'"
	 * @generated
	 */
	EBlendFactor getDstColor();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#getDstColor <em>Dst Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dst Color</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EBlendFactor
	 * @see #getDstColor()
	 * @generated
	 */
	void setDstColor(EBlendFactor value);

	/**
	 * Returns the value of the '<em><b>Src Alpha</b></em>' attribute.
	 * The default value is <code>"ONE"</code>.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EBlendFactor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src Alpha</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EBlendFactor
	 * @see #setSrcAlpha(EBlendFactor)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getColorBlendAttachment_SrcAlpha()
	 * @model default="ONE" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='2 - Operation'"
	 * @generated
	 */
	EBlendFactor getSrcAlpha();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#getSrcAlpha <em>Src Alpha</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Src Alpha</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EBlendFactor
	 * @see #getSrcAlpha()
	 * @generated
	 */
	void setSrcAlpha(EBlendFactor value);

	/**
	 * Returns the value of the '<em><b>Dst Alpha</b></em>' attribute.
	 * The default value is <code>"ZERO"</code>.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EBlendFactor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dst Alpha</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EBlendFactor
	 * @see #setDstAlpha(EBlendFactor)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getColorBlendAttachment_DstAlpha()
	 * @model default="ZERO" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='2 - Operation'"
	 * @generated
	 */
	EBlendFactor getDstAlpha();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#getDstAlpha <em>Dst Alpha</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dst Alpha</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EBlendFactor
	 * @see #getDstAlpha()
	 * @generated
	 */
	void setDstAlpha(EBlendFactor value);

	/**
	 * Returns the value of the '<em><b>Color Blend Op</b></em>' attribute.
	 * The default value is <code>"ADD"</code>.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EBlendOp}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color Blend Op</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EBlendOp
	 * @see #setColorBlendOp(EBlendOp)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getColorBlendAttachment_ColorBlendOp()
	 * @model default="ADD" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='2 - Operation'"
	 * @generated
	 */
	EBlendOp getColorBlendOp();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#getColorBlendOp <em>Color Blend Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color Blend Op</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EBlendOp
	 * @see #getColorBlendOp()
	 * @generated
	 */
	void setColorBlendOp(EBlendOp value);

	/**
	 * Returns the value of the '<em><b>Alpha Blend Op</b></em>' attribute.
	 * The default value is <code>"ADD"</code>.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EBlendOp}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alpha Blend Op</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EBlendOp
	 * @see #setAlphaBlendOp(EBlendOp)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getColorBlendAttachment_AlphaBlendOp()
	 * @model default="ADD" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='2 - Operation'"
	 * @generated
	 */
	EBlendOp getAlphaBlendOp();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#getAlphaBlendOp <em>Alpha Blend Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alpha Blend Op</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EBlendOp
	 * @see #getAlphaBlendOp()
	 * @generated
	 */
	void setAlphaBlendOp(EBlendOp value);

	/**
	 * Returns the value of the '<em><b>Red Component Enable</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Red Component Enable</em>' attribute.
	 * @see #setRedComponentEnable(boolean)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getColorBlendAttachment_RedComponentEnable()
	 * @model default="true" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='3 - Component'"
	 * @generated
	 */
	boolean isRedComponentEnable();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#isRedComponentEnable <em>Red Component Enable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Red Component Enable</em>' attribute.
	 * @see #isRedComponentEnable()
	 * @generated
	 */
	void setRedComponentEnable(boolean value);

	/**
	 * Returns the value of the '<em><b>Green Component Enable</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Green Component Enable</em>' attribute.
	 * @see #setGreenComponentEnable(boolean)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getColorBlendAttachment_GreenComponentEnable()
	 * @model default="true" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='3 - Component'"
	 * @generated
	 */
	boolean isGreenComponentEnable();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#isGreenComponentEnable <em>Green Component Enable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Green Component Enable</em>' attribute.
	 * @see #isGreenComponentEnable()
	 * @generated
	 */
	void setGreenComponentEnable(boolean value);

	/**
	 * Returns the value of the '<em><b>Blue Component Enable</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Blue Component Enable</em>' attribute.
	 * @see #setBlueComponentEnable(boolean)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getColorBlendAttachment_BlueComponentEnable()
	 * @model default="true" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='3 - Component'"
	 * @generated
	 */
	boolean isBlueComponentEnable();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#isBlueComponentEnable <em>Blue Component Enable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Blue Component Enable</em>' attribute.
	 * @see #isBlueComponentEnable()
	 * @generated
	 */
	void setBlueComponentEnable(boolean value);

	/**
	 * Returns the value of the '<em><b>Alpha Component Enable</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alpha Component Enable</em>' attribute.
	 * @see #setAlphaComponentEnable(boolean)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getColorBlendAttachment_AlphaComponentEnable()
	 * @model default="true" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyCategory='3 - Component'"
	 * @generated
	 */
	boolean isAlphaComponentEnable();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment#isAlphaComponentEnable <em>Alpha Component Enable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alpha Component Enable</em>' attribute.
	 * @see #isAlphaComponentEnable()
	 * @generated
	 */
	void setAlphaComponentEnable(boolean value);

} // ColorBlendAttachment

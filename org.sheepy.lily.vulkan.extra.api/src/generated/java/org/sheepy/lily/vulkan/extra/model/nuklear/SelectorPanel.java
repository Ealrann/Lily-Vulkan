/**
 */
package org.sheepy.lily.vulkan.extra.model.nuklear;

import org.sheepy.lily.core.model.presentation.IPanel;

import org.sheepy.lily.core.model.variable.DirectVariableResolver;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Selector Panel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#getButtonSizePx <em>Button Size Px</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#getSelectionR <em>Selection R</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#getSelectionG <em>Selection G</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#getSelectionB <em>Selection B</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#isPrintLabels <em>Print Labels</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#getVariableResolver <em>Variable Resolver</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#getInputProvider <em>Input Provider</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#isVertical <em>Vertical</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#isAutoHideLabels <em>Auto Hide Labels</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#getFadeOutMs <em>Fade Out Ms</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getSelectorPanel()
 * @model
 * @generated
 */
public interface SelectorPanel extends IPanel
{
	/**
	 * Returns the value of the '<em><b>Button Size Px</b></em>' attribute.
	 * The default value is <code>"32"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Button Size Px</em>' attribute.
	 * @see #setButtonSizePx(int)
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getSelectorPanel_ButtonSizePx()
	 * @model default="32" required="true"
	 * @generated
	 */
	int getButtonSizePx();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#getButtonSizePx <em>Button Size Px</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Button Size Px</em>' attribute.
	 * @see #getButtonSizePx()
	 * @generated
	 */
	void setButtonSizePx(int value);

	/**
	 * Returns the value of the '<em><b>Selection R</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selection R</em>' attribute.
	 * @see #setSelectionR(int)
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getSelectorPanel_SelectionR()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getSelectionR();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#getSelectionR <em>Selection R</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selection R</em>' attribute.
	 * @see #getSelectionR()
	 * @generated
	 */
	void setSelectionR(int value);

	/**
	 * Returns the value of the '<em><b>Selection G</b></em>' attribute.
	 * The default value is <code>"135"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selection G</em>' attribute.
	 * @see #setSelectionG(int)
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getSelectorPanel_SelectionG()
	 * @model default="135" required="true"
	 * @generated
	 */
	int getSelectionG();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#getSelectionG <em>Selection G</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selection G</em>' attribute.
	 * @see #getSelectionG()
	 * @generated
	 */
	void setSelectionG(int value);

	/**
	 * Returns the value of the '<em><b>Selection B</b></em>' attribute.
	 * The default value is <code>"255"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selection B</em>' attribute.
	 * @see #setSelectionB(int)
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getSelectorPanel_SelectionB()
	 * @model default="255" required="true"
	 * @generated
	 */
	int getSelectionB();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#getSelectionB <em>Selection B</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selection B</em>' attribute.
	 * @see #getSelectionB()
	 * @generated
	 */
	void setSelectionB(int value);

	/**
	 * Returns the value of the '<em><b>Print Labels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Print Labels</em>' attribute.
	 * @see #setPrintLabels(boolean)
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getSelectorPanel_PrintLabels()
	 * @model required="true"
	 * @generated
	 */
	boolean isPrintLabels();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#isPrintLabels <em>Print Labels</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Print Labels</em>' attribute.
	 * @see #isPrintLabels()
	 * @generated
	 */
	void setPrintLabels(boolean value);

	/**
	 * Returns the value of the '<em><b>Variable Resolver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Resolver</em>' containment reference.
	 * @see #setVariableResolver(DirectVariableResolver)
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getSelectorPanel_VariableResolver()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DirectVariableResolver getVariableResolver();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#getVariableResolver <em>Variable Resolver</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Resolver</em>' containment reference.
	 * @see #getVariableResolver()
	 * @generated
	 */
	void setVariableResolver(DirectVariableResolver value);

	/**
	 * Returns the value of the '<em><b>Input Provider</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Provider</em>' containment reference.
	 * @see #setInputProvider(IInputProvider)
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getSelectorPanel_InputProvider()
	 * @model containment="true" required="true"
	 * @generated
	 */
	IInputProvider getInputProvider();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#getInputProvider <em>Input Provider</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Provider</em>' containment reference.
	 * @see #getInputProvider()
	 * @generated
	 */
	void setInputProvider(IInputProvider value);

	/**
	 * Returns the value of the '<em><b>Vertical</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vertical</em>' attribute.
	 * @see #setVertical(boolean)
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getSelectorPanel_Vertical()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isVertical();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#isVertical <em>Vertical</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vertical</em>' attribute.
	 * @see #isVertical()
	 * @generated
	 */
	void setVertical(boolean value);

	/**
	 * Returns the value of the '<em><b>Auto Hide Labels</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Auto Hide Labels</em>' attribute.
	 * @see #setAutoHideLabels(boolean)
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getSelectorPanel_AutoHideLabels()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isAutoHideLabels();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#isAutoHideLabels <em>Auto Hide Labels</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Auto Hide Labels</em>' attribute.
	 * @see #isAutoHideLabels()
	 * @generated
	 */
	void setAutoHideLabels(boolean value);

	/**
	 * Returns the value of the '<em><b>Fade Out Ms</b></em>' attribute.
	 * The default value is <code>"500"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fade Out Ms</em>' attribute.
	 * @see #setFadeOutMs(int)
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getSelectorPanel_FadeOutMs()
	 * @model default="500" required="true"
	 * @generated
	 */
	int getFadeOutMs();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel#getFadeOutMs <em>Fade Out Ms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fade Out Ms</em>' attribute.
	 * @see #getFadeOutMs()
	 * @generated
	 */
	void setFadeOutMs(int value);

} // SelectorPanel

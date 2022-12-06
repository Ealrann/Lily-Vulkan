/**
 */
package org.sheepy.lily.vulkan.extra.model.nuklear.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.sheepy.lily.vulkan.extra.model.nuklear.FontImageProvider;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFactory;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPushConstants;
import org.sheepy.lily.vulkan.extra.model.nuklear.PanelViewer;
import org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NuklearFactoryImpl extends EFactoryImpl implements NuklearFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NuklearFactory init()
	{
		try
		{
			NuklearFactory theNuklearFactory = (NuklearFactory)EPackage.Registry.INSTANCE.getEFactory(NuklearPackage.eNS_URI);
			if (theNuklearFactory != null)
			{
				return theNuklearFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new NuklearFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NuklearFactoryImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass)
	{
		switch (eClass.getClassifierID())
		{
			case NuklearPackage.NUKLEAR_PUSH_CONSTANTS: return createNuklearPushConstants();
			case NuklearPackage.NUKLEAR_CONTEXT: return createNuklearContext();
			case NuklearPackage.NUKLEAR_FONT: return createNuklearFont();
			case NuklearPackage.SELECTOR_PANEL: return createSelectorPanel();
			case NuklearPackage.PANEL_VIEWER: return createPanelViewer();
			case NuklearPackage.FONT_IMAGE_PROVIDER: return createFontImageProvider();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NuklearPushConstants createNuklearPushConstants()
	{
		NuklearPushConstantsImpl nuklearPushConstants = new NuklearPushConstantsImpl();
		return nuklearPushConstants;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NuklearContext createNuklearContext()
	{
		NuklearContextImpl nuklearContext = new NuklearContextImpl();
		return nuklearContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NuklearFont createNuklearFont()
	{
		NuklearFontImpl nuklearFont = new NuklearFontImpl();
		return nuklearFont;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SelectorPanel createSelectorPanel()
	{
		SelectorPanelImpl selectorPanel = new SelectorPanelImpl();
		return selectorPanel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PanelViewer createPanelViewer()
	{
		PanelViewerImpl panelViewer = new PanelViewerImpl();
		return panelViewer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FontImageProvider createFontImageProvider()
	{
		FontImageProviderImpl fontImageProvider = new FontImageProviderImpl();
		return fontImageProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NuklearPackage getNuklearPackage()
	{
		return (NuklearPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static NuklearPackage getPackage()
	{
		return NuklearPackage.eINSTANCE;
	}

} //NuklearFactoryImpl
